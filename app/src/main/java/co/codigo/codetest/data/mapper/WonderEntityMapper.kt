package co.codigo.codetest.data.mapper

import co.codigo.codetest.data.base.EntityMapper
import co.codigo.codetest.data.database.entity.WonderEntity
import co.codigo.codetest.domain.models.Wonder
import co.codigo.codetest.domain.models.WonderLocation

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderEntityMapper : EntityMapper<Wonder, WonderEntity>() {

    override fun transform(dataModel: WonderEntity): Wonder {
        return with(dataModel) {
            Wonder(
                name = name,
                description = description,
                image = imageUrl,
                location = WonderLocation(lat, lng)
            )
        }
    }
}