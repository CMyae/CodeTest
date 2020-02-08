package co.codigo.codetest.data.mapper

import co.codigo.codetest.data.base.ReverseEntityMapper
import co.codigo.codetest.data.database.entity.WonderEntity
import co.codigo.codetest.domain.models.Wonder

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderReverseEntityMapper : ReverseEntityMapper<WonderEntity, Wonder>() {

    override fun reverseTransform(domainModel: Wonder): WonderEntity {
        return with(domainModel) {
            WonderEntity(
                name = this.name,
                imageUrl = this.image,
                description = this.description,
                lat = this.location.lat,
                lng = this.location.lng
            )
        }
    }
}