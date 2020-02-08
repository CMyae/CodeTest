package co.codigo.codetest.presentation.features.wonderlist

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import co.codigo.codetest.R
import co.codigo.codetest.presentation.features.detail.WonderDetailActivity
import co.codigo.codetest.presentation.internal.Lce
import co.codigo.codetest.presentation.internal.base.BaseActivity
import co.codigo.codetest.presentation.internal.di.ViewModelFactory
import co.codigo.codetest.presentation.internal.extensions.toGone
import co.codigo.codetest.presentation.internal.extensions.toVisible
import co.codigo.codetest.presentation.internal.extensions.viewModelProvider
import co.codigo.codetest.presentation.model.WonderUiModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_wonders.*
import kotlinx.android.synthetic.main.include_toolbar.*
import javax.inject.Inject

class WondersActivity : BaseActivity(), WondersAdapter.WonderItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        viewModelProvider<WonderViewModel>(viewModelFactory)
    }

    private val itemAdapter by lazy { WondersAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wonders)

        setUpToolbar()
        setUpRecyclerView()
        observeWonderList()

        if (savedInstanceState == null) {
            viewModel.getWonderItems()
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.label_wonder)
    }

    private fun setUpRecyclerView() {
        rvWonders.apply {
            layoutManager = LinearLayoutManager(this@WondersActivity)
            setHasFixedSize(true)
            adapter = itemAdapter
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
                renderWonderItems(it.content)
            }
        })
    }

    private fun renderWonderItems(items: List<WonderUiModel>) {
        itemAdapter.submitList(items)
    }

    private fun showLoading() {
        loadingShimmer.toVisible()
    }

    private fun hideLoading() {
        loadingShimmer.toGone()
    }

    override fun onWonderItemClick(model: WonderUiModel) {
        WonderDetailActivity.start(this, model)
    }
}
