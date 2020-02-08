package co.codigo.codetest.data.service

import co.codigo.codetest.data.model.WonderResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
interface WonderService {
  @GET("bins/13g69v")
  fun getWonderItems(): Single<WonderResponse>
}