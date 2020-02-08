package co.codigo.codetest.data.repo.datasource

import co.codigo.codetest.data.database.WonderDatabase
import co.codigo.codetest.data.mapper.WonderEntityMapper
import co.codigo.codetest.data.mapper.WonderReverseEntityMapper
import co.codigo.codetest.domain.models.Wonder
import io.reactivex.Single

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderLocalDataSourceImpl(private val wonderDatabase: WonderDatabase) :
    WonderLocalDataSource {

    private val wonderEntityMapper = WonderEntityMapper()
    private val wonderReverseEntityMapper = WonderReverseEntityMapper()

    override fun getWonderItemFromDB(): Single<List<Wonder>> {
        return wonderDatabase.wonderPlaceDao().getWonderItems().map(wonderEntityMapper::transform)
    }

    override fun saveWonderItemInDB(wonders: List<Wonder>) {
        wonderDatabase.wonderPlaceDao()
            .insertAll(wonderReverseEntityMapper.reverseTransform(wonders))
    }

}