package co.codigo.codetest.presentation.internal.di.modules

import androidx.lifecycle.ViewModel
import co.codigo.codetest.presentation.features.wonderlist.WonderViewModel
import co.codigo.codetest.presentation.internal.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WonderViewModel::class)
    abstract fun bindWonderViewModel(jobViewModel: WonderViewModel): ViewModel
}