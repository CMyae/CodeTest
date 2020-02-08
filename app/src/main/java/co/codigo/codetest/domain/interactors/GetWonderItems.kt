package co.codigo.codetest.domain.interactors

import co.codigo.codetest.domain.repo.WonderRepo
import co.codigo.codetest.domain.executors.PostExecutionThread
import co.codigo.codetest.domain.executors.ThreadExecutor
import co.codigo.codetest.domain.models.Wonder
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class GetWonderItems @Inject constructor(
    private val wonderRepo: WonderRepo,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<Wonder>, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit?): Observable<List<Wonder>> {
        return wonderRepo.getWonderItems().filter { it.isNotEmpty() }
    }

}