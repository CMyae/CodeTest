package co.codigo.codetest.presentation.mapper

import co.codigo.codetest.domain.models.Wonder
import co.codigo.codetest.presentation.model.WonderLocationUiModel
import co.codigo.codetest.presentation.model.WonderUiModel

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderUiModelMapper : ViewModelMapper<WonderUiModel, Wonder>() {

    override fun transform(domainModel: Wonder): WonderUiModel {
        return with(domainModel) {
            WonderUiModel(
                name = name,
                description = description,
                imageUrl = image,
                location = WonderLocationUiModel(location.lat, location.lng)
            )
        }
    }
}