package co.codigo.codetest.presentation.internal

/**
 * Created by Chan Myae Aung on 2/8/20.
 */

public sealed class Lce<out T : Any>{
    public object Loading : Lce<Nothing>()
    public data class Error(val throwable: Throwable) : Lce<Nothing>()
    public data class Content<out T : Any>(val content: T) : Lce<T>()
}