package co.codigo.codetest.mapper

import co.codigo.codetest.domain.models.Wonder
import co.codigo.codetest.domain.models.WonderLocation
import co.codigo.codetest.presentation.mapper.WonderUiModelMapper
import co.codigo.codetest.presentation.model.WonderLocationUiModel
import co.codigo.codetest.presentation.model.WonderUiModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderUiModelMapperTest {

    private val mapper = WonderUiModelMapper()
    private val list = mutableListOf<Wonder>()

    @Before
    fun before() {
        list.clear()
        list.add(
            Wonder("Place name 1", "description 1", "url 1", WonderLocation(0.1, 0.1))
        )
    }

    @Test
    fun `test ui model mapper map correctly`() {
        val actual = mapper.transform(list)
        val expected = listOf(
            WonderUiModel("Place name 1", "description 1", "url 1", WonderLocationUiModel(0.1, 0.1))
        )
        assertEquals(expected, actual)
    }
}