package co.codigo.codetest.data.repo

import co.codigo.codetest.data.repo.datasource.WonderLocalDataSource
import co.codigo.codetest.data.repo.datasource.WonderNetworkDataSource
import co.codigo.codetest.domain.models.Wonder
import co.codigo.codetest.domain.repo.WonderRepo
import io.reactivex.Single

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderRepoImpl(
    val networkDataSource: WonderNetworkDataSource,
    val localDataSource: WonderLocalDataSource
) : WonderRepo {

    override fun getWonderItems(): Single<List<Wonder>> {
        return networkDataSource.fetchWonderItems()
    }
}