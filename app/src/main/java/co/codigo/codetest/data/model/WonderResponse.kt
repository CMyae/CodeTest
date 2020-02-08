package co.codigo.codetest.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
data class WonderResponse(@SerializedName("wonders") val wonders: List<WonderItem>)

data class WonderItem(
    @SerializedName("location") val location: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("lat") val lat: String,
    @SerializedName("long") val lng: String
)