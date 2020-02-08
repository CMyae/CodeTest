package co.codigo.codetest.data.repo.datasource

import co.codigo.codetest.domain.models.Wonder
import io.reactivex.Single

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
interface WonderLocalDataSource {

    fun getWonderItemFromDB(): Single<List<Wonder>>
}