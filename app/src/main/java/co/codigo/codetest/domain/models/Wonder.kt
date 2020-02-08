package co.codigo.codetest.domain.models

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
data class Wonder(
    val name: String,
    val description: String,
    val image: String,
    val location: WonderLocation
)

data class WonderLocation(val lat: Double, val lng: Double)