package co.codigo.codetest.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Parcelize
data class WonderUiModel(
    val name: String,
    val description: String,
    val imageUrl: String,
    val location: WonderLocationUiModel
) : Parcelable

@Parcelize
data class WonderLocationUiModel(val lat: Double, val lng: Double) : Parcelable