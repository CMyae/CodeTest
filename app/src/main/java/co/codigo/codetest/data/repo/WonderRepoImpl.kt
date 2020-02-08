package co.codigo.codetest.data.repo

import co.codigo.codetest.data.repo.WonderRepo
import co.codigo.codetest.data.repo.datasource.WonderLocalDataSource
import co.codigo.codetest.data.repo.datasource.WonderNetworkDataSource

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WonderRepoImpl(
  val networkDataSource: WonderNetworkDataSource,
  val localDataSource: WonderLocalDataSource
) : WonderRepo {
}