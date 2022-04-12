package com.myapplication.gitaday14.ui.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myapplication.gitaday14.ui.model.Cookie


@Dao
interface CookieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCookie(cookie: Cookie)

    @Query("SELECT * FROM ${Cookie.TABLE_NAME}")
    suspend fun fetchAllCookies(): List<Cookie>

    @Query("SELECT * FROM ${Cookie.TABLE_NAME} WHERE id = (SELECT MAX(id) FROM ${Cookie.TABLE_NAME})")
    fun selectLast(): List<Cookie>

    @Query("SELECT EXISTS (SELECT 1 FROM ${Cookie.TABLE_NAME} WHERE id = :id)")
    suspend fun exists(id: Int): Boolean
}