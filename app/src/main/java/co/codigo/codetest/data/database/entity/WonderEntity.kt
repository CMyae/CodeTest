package co.codigo.codetest.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Entity
data class WonderEntity(
    @PrimaryKey val name: String,
    val imageUrl: String,
    val description: String,
    val lat: Double,
    val lng: Double
)