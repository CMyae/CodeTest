package co.codigo.codetest.presentation.internal.base

import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import co.codigo.codetest.R
import java.net.UnknownHostException

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
abstract class BaseActivity : AppCompatActivity() {

    private var dialog: AlertDialog? = null

    protected fun renderError(throwable: Throwable) {
        if (throwable is UnknownHostException) {
            Toast.makeText(this, getString(R.string.label_no_internet), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
        }
    }

    protected fun showLoadingDialog(@StringRes message: Int) {
        dialog = AlertDialog.Builder(this).create()
        val view = layoutInflater.inflate(R.layout.dialog_loading, null)
        dialog?.setView(view)
        dialog?.setCanceledOnTouchOutside(false)
        view.findViewById<TextView>(R.id.tv_loading_title).text = getString(message)
        dialog?.show()
    }

    protected fun hideLoadingDialog() {
        dialog?.cancel()
    }

    protected fun showToast(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}