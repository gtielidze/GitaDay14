package com.myapplication.gitaday14.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myapplication.gitaday14.ui.model.Cookie
import kotlinx.coroutines.CoroutineScope


@Database(entities = [Cookie::class], version = 2)
abstract class CookieDataBase: RoomDatabase(){
    abstract fun getCookieDao(): CookieDao
    companion object {
        const val DB_NAME = "cookie_database"

        @Volatile
        private var INSTANCE: CookieDataBase? = null

        operator fun invoke(context: Context, applicationScope: CoroutineScope) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CookieDataBase::class.java,
            DB_NAME
        ).build()


    }



}