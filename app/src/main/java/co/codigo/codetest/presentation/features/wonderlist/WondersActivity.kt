package co.codigo.codetest.presentation.features.wonderlist

import android.os.Bundle
import androidx.lifecycle.Observer
import co.codigo.codetest.R
import co.codigo.codetest.presentation.internal.Lce
import co.codigo.codetest.presentation.internal.base.BaseActivity
import co.codigo.codetest.presentation.internal.di.ViewModelFactory
import co.codigo.codetest.presentation.internal.extensions.toGone
import co.codigo.codetest.presentation.internal.extensions.toVisible
import co.codigo.codetest.presentation.internal.extensions.viewModelProvider
import co.codigo.codetest.presentation.model.WonderUiModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_wonders.*
import javax.inject.Inject

class WondersActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        viewModelProvider<WonderViewModel>(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wonders)

        observeWonderList()

        if (savedInstanceState == null) {
            viewModel.getWonderItems()
        }
    }

    private fun observeWonderList() {
        viewModel.observeWonderItems().observe(this, Observer {
            if (it is Lce.Loading) {
                showLoading()
            } else {
                hideLoading()
            }
            if (it is Lce.Error) {
                renderError(it.throwable)
            }
            if (it is Lce.Content) {
                renderWonderItems(listOf())
            }
        })
    }

    private fun renderWonderItems(items: List<WonderUiModel>) {

    }

    private fun showLoading() {
        progressBar.toVisible()
    }

    private fun hideLoading() {
        progressBar.toGone()
    }
}