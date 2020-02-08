package co.codigo.codetest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.codigo.codetest.data.database.entity.WonderEntity
import io.reactivex.Single


/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Dao
interface WonderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(wonderItems: List<WonderEntity>)

    @Query("SELECT * FROM WonderEntity")
    fun getWonderItems(): Single<List<WonderEntity>>

}