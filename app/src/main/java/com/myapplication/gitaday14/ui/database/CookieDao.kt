package com.myapplication.gitaday14.ui.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myapplication.gitaday14.ui.model.Cookie
import kotlinx.coroutines.flow.Flow


@Dao
interface CookieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cookie: Cookie)

    @Query("SELECT * FROM ${Cookie.TABLE_NAME} ORDER BY id ASC")
    fun fetchAllCookies(): Flow<List<Cookie>>

    @Query("SELECT * FROM ${Cookie.TABLE_NAME} WHERE id = (SELECT MAX(id) FROM ${Cookie.TABLE_NAME})")
    suspend fun selectLast(): List<Cookie>

    @Query("SELECT EXISTS (SELECT 1 FROM ${Cookie.TABLE_NAME} WHERE id = :id)")
    suspend fun exists(id: Int): Boolean
}