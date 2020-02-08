package co.codigo.codetest.presentation.features.wonderlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.codigo.codetest.domain.interactors.GetWonderItems
import co.codigo.codetest.domain.models.Wonder
import co.codigo.codetest.presentation.internal.Lce
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderViewModel @Inject constructor(
    private val getWonderItems: GetWonderItems
) : ViewModel() {

    private val _wonderLiveData = MutableLiveData<Lce<List<Wonder>>>()

    fun getWonderItems() {
        _wonderLiveData.postValue(Lce.Loading)
        getWonderItems.execute(object : DisposableSingleObserver<List<Wonder>>() {
            override fun onSuccess(result: List<Wonder>) {
                _wonderLiveData.postValue(Lce.Content(result))
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
                _wonderLiveData.postValue(Lce.Error(e))
            }

        })
    }

    fun observeWonderItems() = _wonderLiveData

    override fun onCleared() {
        super.onCleared()
        getWonderItems.dispose()
    }
}