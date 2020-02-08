package co.codigo.codetest.presentation.internal.di.modules

import android.content.Context
import androidx.room.Room
import co.codigo.codetest.R
import co.codigo.codetest.data.database.WonderDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideWonderDatabase(context: Context): WonderDatabase {
        return Room.databaseBuilder(
            context, WonderDatabase::class.java, context.getString(R.string.wonder_db_name)
        ).build()
    }
}