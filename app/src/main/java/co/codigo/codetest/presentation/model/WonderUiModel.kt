package co.codigo.codetest.presentation.model

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
data class WonderUiModel(
    val locationName: String,
    val description: String,
    val image: String,
    val location: WonderLocationUiModel
)

data class WonderLocationUiModel(val lat: String, val lng: String)