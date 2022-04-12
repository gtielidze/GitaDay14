package com.myapplication.gitaday14.ui

import android.app.Application
import com.myapplication.gitaday14.ui.database.CookieDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { CookieDataBase.invoke(this, applicationScope) }
    val repository by lazy { CookieRepository(database.getCookieDao()) }
}
