package co.codigo.codetest.domain.executors

import io.reactivex.Scheduler

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
interface PostExecutionThread {
  fun getScheduler(): Scheduler?
}