package co.codigo.codetest.data.repo.datasource

import co.codigo.codetest.data.mapper.WonderResponseMapper
import co.codigo.codetest.data.service.WonderService
import co.codigo.codetest.domain.models.Wonder
import io.reactivex.Single
import retrofit2.Retrofit

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderNetworkDataSourceImpl(private val retrofit: Retrofit) : WonderNetworkDataSource {

    private val wonderService = retrofit.create(WonderService::class.java)

    private val wonderResponseMapper = WonderResponseMapper()

    override fun fetchWonderItems(): Single<List<Wonder>> {
        return wonderService.getWonderItems().map { wonderResponseMapper.transform(it.wonders) }
            .retry(2)
            .onErrorResumeNext {
                //can send error log to server like Sentry
                it.printStackTrace()
                Single.just(listOf())
            }
    }
}