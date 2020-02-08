package co.codigo.codetest.data

import co.codigo.codetest.domain.executors.ThreadExecutor
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class JobExecutor @Inject constructor() : ThreadExecutor {
  private val workQueue: BlockingQueue<Runnable?>?
  private val threadPoolExecutor: ThreadPoolExecutor?
  private val threadFactory: ThreadFactory?
  override fun execute(runnable: Runnable?) {
    requireNotNull(runnable) { "Runnable to execute cannot be null" }
    threadPoolExecutor?.execute(runnable)
  }

  private class JobThreadFactory : ThreadFactory {
    private var counter = 0
    override fun newThread(runnable: Runnable?): Thread? {
      return Thread(
          runnable, THREAD_NAME + counter++
      )
    }

    companion object {
      private val THREAD_NAME: String? = "android_"
    }
  }

  init {
    workQueue = LinkedBlockingQueue()
    threadFactory = JobThreadFactory()
    threadPoolExecutor = ThreadPoolExecutor(
        INITIAL_POOL_SIZE, MAX_POOL_SIZE,
        KEEP_ALIVE_TIME.toLong(),
        KEEP_ALIVE_TIME_UNIT, this.workQueue, this.threadFactory
    )
  }

  companion object {
    private const val INITIAL_POOL_SIZE = 3
    private const val MAX_POOL_SIZE = 5
    // Sets the amount of time an idle thread waits before terminating
    private const val KEEP_ALIVE_TIME = 10
    // Sets the Time Unit to seconds
    private val KEEP_ALIVE_TIME_UNIT: TimeUnit? = TimeUnit.SECONDS
  }
}