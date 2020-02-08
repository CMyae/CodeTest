package co.codigo.codetest.data.base

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
abstract class BaseReverseDataMapper<DM, M> {
    abstract fun reverseTransform(domainModel: M): DM
    fun reverseTransform(domainModels: List<M>): List<DM> {
        val dataModels: MutableList<DM> = ArrayList()
        for (domainModel in domainModels) {
            dataModels.add(reverseTransform(domainModel))
        }
        return dataModels
    }
}