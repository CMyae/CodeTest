package co.codigo.codetest.presentation.internal.di.components

import co.codigo.codetest.presentation.WonderApplication
import co.codigo.codetest.presentation.internal.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AndroidInjectionModule::class, ApplicationModule::class,
        ActivityModule::class, NetworkModule::class, RepoModule::class, DatabaseModule::class,
        ViewModelModule::class]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: WonderApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: WonderApplication)
}