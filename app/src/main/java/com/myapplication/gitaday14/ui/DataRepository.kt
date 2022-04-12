package com.myapplication.gitaday14.ui

import androidx.annotation.WorkerThread
import com.myapplication.gitaday14.ui.database.CookieDao
import com.myapplication.gitaday14.ui.model.Cookie
import kotlinx.coroutines.flow.Flow

class CookieRepository(private val cookieDao: CookieDao) {
    val allCookie: Flow<List<Cookie>> = cookieDao.fetchAllCookies()


    @WorkerThread
    suspend fun insert(cookie: Cookie) {
        cookieDao.insert(cookie)
    }

    @WorkerThread
    suspend fun check(id: Int):Boolean {
        return cookieDao.exists(id)
    }

    //@WorkerThread
    suspend fun selectLast(): Cookie {
        return cookieDao.selectLast()[0]
    }
}