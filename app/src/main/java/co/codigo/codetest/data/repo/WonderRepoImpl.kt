package co.codigo.codetest.data.repo

import co.codigo.codetest.data.repo.datasource.WonderLocalDataSource
import co.codigo.codetest.data.repo.datasource.WonderNetworkDataSource
import co.codigo.codetest.domain.models.Wonder
import co.codigo.codetest.domain.repo.WonderRepo
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderRepoImpl(
    private val networkDataSource: WonderNetworkDataSource,
    private val localDataSource: WonderLocalDataSource
) : WonderRepo {

    override fun getWonderItems(): Observable<List<Wonder>> {
        val networkObservable = networkDataSource.fetchWonderItems().toObservable()
            .doOnNext {
                localDataSource.saveWonderItemInDB(it)
            }
        val localObservable = localDataSource.getWonderItemFromDB().toObservable()

        return Observable.concat(localObservable, networkObservable)
    }
}

