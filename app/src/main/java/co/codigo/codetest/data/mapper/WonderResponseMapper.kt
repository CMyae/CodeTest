package co.codigo.codetest.data.mapper

import co.codigo.codetest.data.base.BaseDataMapper
import co.codigo.codetest.data.model.WonderItem
import co.codigo.codetest.domain.models.Wonder
import co.codigo.codetest.domain.models.WonderLocation

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderResponseMapper : BaseDataMapper<Wonder, WonderItem>() {

    override fun transform(dataModel: WonderItem): Wonder {
        return with(dataModel) {
            Wonder(
                name = location,
                description = description,
                image = image,
                location = WonderLocation(lat.toDouble(), lng.toDouble())
            )
        }
    }
}