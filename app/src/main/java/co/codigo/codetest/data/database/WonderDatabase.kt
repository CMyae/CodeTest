package co.codigo.codetest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import co.codigo.codetest.data.database.dao.WonderDao
import co.codigo.codetest.data.database.entity.WonderEntity

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Database(entities = [WonderEntity::class], version = 1)
abstract class WonderDatabase : RoomDatabase() {

    abstract fun wonderPlaceDao(): WonderDao
}