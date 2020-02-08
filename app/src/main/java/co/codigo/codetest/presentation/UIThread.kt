package co.codigo.codetest.presentation

import co.codigo.codetest.domain.executors.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Singleton
class UIThread @Inject constructor() : PostExecutionThread {
  override fun getScheduler(): Scheduler? {
    return AndroidSchedulers.mainThread()
  }
}