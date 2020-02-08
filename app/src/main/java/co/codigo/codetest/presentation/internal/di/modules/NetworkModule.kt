package co.codigo.codetest.presentation.internal.di.modules

import co.codigo.codetest.BuildConfig
import co.codigo.codetest.data.HttpLoggingInterceptor
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigDecimal
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Chan Myae Aung on 2/8/20.
 */

@Module
class NetworkModule {
  @Singleton
  @Provides
  fun provideRetrofit(): Retrofit {

    val gsonBuilder = GsonBuilder()
    gsonBuilder.setExclusionStrategies(object : ExclusionStrategy {
      override fun shouldSkipField(f: FieldAttributes): Boolean {
        return f.name.startsWith("_")
      }

      override fun shouldSkipClass(incomingClass: Class<*>?): Boolean {
        return false
      }
    })

    gsonBuilder.registerTypeAdapter(Double::class.java,
        JsonSerializer<Double?> { src, typeOfSrc, context ->
          val value = BigDecimal.valueOf(src!!)
          JsonPrimitive(value.toPlainString())
        })

    val gson = gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        .serializeNulls()
        .create()

    val httpClient =
      OkHttpClient.Builder()
          .connectTimeout(3, TimeUnit.MINUTES)
          .readTimeout(3, TimeUnit.MINUTES)

    if (BuildConfig.DEBUG) {
      val httpLoggingInterceptor = HttpLoggingInterceptor()
      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
      httpClient.addInterceptor(httpLoggingInterceptor)
    }

    return Retrofit.Builder()
        .baseUrl("https://api.myjson.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(httpClient.build())
        .build()
  }
}