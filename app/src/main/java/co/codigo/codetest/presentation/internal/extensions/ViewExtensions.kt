package co.codigo.codetest.presentation.internal.extensions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Chan Myae Aung on 2/8/20.
 */

fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun ImageView.load(url: String) {
    Glide.with(this).load(url).into(this)
}