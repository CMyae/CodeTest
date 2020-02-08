package co.codigo.codetest.domain.repo

import co.codigo.codetest.domain.models.Wonder
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
interface WonderRepo {

    fun getWonderItems(): Observable<List<Wonder>>
}