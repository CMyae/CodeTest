package co.codigo.codetest.domain.models

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
data class Wonder(
    val locationName: String,
    val description: String,
    val image: String,
    val location: WonderLocation
)

data class WonderLocation(val lat: String, val lng: String)