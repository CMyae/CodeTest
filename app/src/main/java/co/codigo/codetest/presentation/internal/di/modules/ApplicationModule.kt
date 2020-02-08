package co.codigo.codetest.presentation.internal.di.modules

import android.content.Context
import co.codigo.codetest.data.JobExecutor
import co.codigo.codetest.domain.executors.PostExecutionThread
import co.codigo.codetest.domain.executors.ThreadExecutor
import co.codigo.codetest.presentation.UIThread
import co.codigo.codetest.presentation.WonderApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Module
class ApplicationModule {

  @Singleton
  @Provides
  fun provideContext(app: WonderApplication): Context {
    return app.applicationContext
  }

  @Singleton
  @Provides
  fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
    return uiThread
  }

  @Singleton
  @Provides
  fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }
}