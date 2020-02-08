package co.codigo.codetest.presentation.internal.extensions

import android.view.View

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