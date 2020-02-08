package co.codigo.codetest.data.base

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
abstract class BaseDataMapper<M, DM> {
    abstract fun transform(dataModel: DM): M

    fun transform(dataModels: List<DM>): List<M> {
        val domainModelList: MutableList<M> = ArrayList(dataModels.size)
        for (dataModel in dataModels) {
            domainModelList.add(transform(dataModel))
        }
        return domainModelList
    }
}