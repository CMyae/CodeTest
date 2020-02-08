package co.codigo.codetest.presentation

import android.app.Application
import co.codigo.codetest.presentation.internal.di.components.ApplicationComponent
import co.codigo.codetest.presentation.internal.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderApplication : Application(), HasAndroidInjector {

  private var applicationComponent: ApplicationComponent? = null

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

  override fun onCreate() {
    super.onCreate()
    if (applicationComponent == null) {
      applicationComponent = DaggerApplicationComponent.builder()
          .application(this)
          .build()
      applicationComponent?.inject(this)
    }
  }

  override fun androidInjector(): AndroidInjector<Any> {
    return dispatchingAndroidInjector
  }
}