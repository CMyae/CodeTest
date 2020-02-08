package co.codigo.codetest.presentation.model

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
data class WonderUiModel(
    val name: String,
    val description: String,
    val imageUrl: String,
    val location: WonderLocationUiModel
)

data class WonderLocationUiModel(val lat: Double, val lng: Double)