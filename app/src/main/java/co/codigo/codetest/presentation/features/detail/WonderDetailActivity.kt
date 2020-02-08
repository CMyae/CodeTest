package co.codigo.codetest.presentation.features.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.codigo.codetest.R
import co.codigo.codetest.presentation.internal.extensions.load
import co.codigo.codetest.presentation.model.WonderUiModel
import kotlinx.android.synthetic.main.activity_wonder_detail.*

class WonderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wonder_detail)

        intent.getParcelableExtra<WonderUiModel>(KEY_MODEL)?.let {
            renderDetail(it)
        }
    }

    private fun renderDetail(model: WonderUiModel) {
        ivWonderPlace.load(model.imageUrl)
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
