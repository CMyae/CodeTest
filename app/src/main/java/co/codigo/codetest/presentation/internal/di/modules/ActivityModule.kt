package co.codigo.codetest.presentation.internal.di.modules

import co.codigo.codetest.presentation.features.wonderlist.WondersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindWonderActivity(): WondersActivity
}