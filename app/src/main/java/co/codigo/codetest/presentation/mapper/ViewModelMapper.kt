package co.codigo.codetest.presentation.mapper

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
abstract class ViewModelMapper<VM, M> {
    abstract fun transform(domainModel: M): VM

    fun transform(dataModels: List<M>): List<VM> {
        val domainModelList: MutableList<VM> = ArrayList(dataModels.size)
        for (dataModel in dataModels) {
            domainModelList.add(transform(dataModel))
        }
        return domainModelList
    }
}