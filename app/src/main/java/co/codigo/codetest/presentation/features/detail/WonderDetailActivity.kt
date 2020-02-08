package co.codigo.codetest.presentation.features.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import co.codigo.codetest.R
import co.codigo.codetest.presentation.internal.extensions.load
import co.codigo.codetest.presentation.model.WonderUiModel
import kotlinx.android.synthetic.main.activity_wonder_detail.*
import kotlinx.android.synthetic.main.include_toolbar.*

class WonderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wonder_detail)

        setUpToolbar()

        intent.getParcelableExtra<WonderUiModel>(KEY_MODEL)?.let {
            renderDetail(it)
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    private fun renderDetail(model: WonderUiModel) {
        supportActionBar?.title = model.name
        ivWonderPlace.load(model.imageUrl)
        tvDescription.text = model.description
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val KEY_MODEL = "key-wonder-model"
        fun start(context: Context, model: WonderUiModel) {
            val intent = Intent(context, WonderDetailActivity::class.java).apply {
                putExtras(Bundle().apply {
                    putParcelable(KEY_MODEL, model)
                })
            }
            context.startActivity(intent)
        }
    }
}
