package co.codigo.codetest.mapper

import co.codigo.codetest.data.mapper.WonderResponseMapper
import co.codigo.codetest.data.model.WonderItem
import co.codigo.codetest.domain.models.Wonder
import co.codigo.codetest.domain.models.WonderLocation
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderResponseMapperTest {

    private val mapper = WonderResponseMapper()
    private val list = mutableListOf<WonderItem>()


    @Before
    fun before() {
        list.clear()
        list.add(
            WonderItem("Place name 1", "description 1", "url 1", "0.1", "0.1")
        )
    }

    @Test
    fun `test ui model mapper map correctly`() {
        val actual = mapper.transform(list)
        val expected = listOf(
            Wonder(
                "Place name 1", "description 1", "url 1",
                WonderLocation(0.1, 0.1)
            )
        )
        TestCase.assertEquals(expected, actual)
    }
}