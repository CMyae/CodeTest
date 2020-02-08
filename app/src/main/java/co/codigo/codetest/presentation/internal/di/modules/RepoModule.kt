package co.codigo.codetest.presentation.internal.di.modules

import co.codigo.codetest.data.database.WonderDatabase
import co.codigo.codetest.domain.repo.WonderRepo
import co.codigo.codetest.data.repo.WonderRepoImpl
import co.codigo.codetest.data.repo.datasource.WonderLocalDataSource
import co.codigo.codetest.data.repo.datasource.WonderLocalDataSourceImpl
import co.codigo.codetest.data.repo.datasource.WonderNetworkDataSource
import co.codigo.codetest.data.repo.datasource.WonderNetworkDataSourceImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Module
class RepoModule {

    @Singleton
    @Provides
    fun provideWonderRepo(
        networkDataSource: WonderNetworkDataSource,
        localDataSource: WonderLocalDataSource
    ): WonderRepo {
        return WonderRepoImpl(networkDataSource, localDataSource)
    }

    @Singleton
    @Provides
    fun provideWonderNetworkDataSource(retrofit: Retrofit): WonderNetworkDataSource {
        return WonderNetworkDataSourceImpl(retrofit)
    }

    @Singleton
    @Provides
    fun provideWonderLocalDataSource(wonderDatabase: WonderDatabase): WonderLocalDataSource {
        return WonderLocalDataSourceImpl(wonderDatabase)
    }
}