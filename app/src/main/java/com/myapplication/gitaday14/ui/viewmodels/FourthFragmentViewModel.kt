package com.myapplication.gitaday14.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.gitaday14.ui.App
import com.myapplication.gitaday14.ui.CookieRepository
import com.myapplication.gitaday14.ui.model.Cookie
import kotlinx.coroutines.launch


class FourthFragmentViewModel(private val repository: CookieRepository) : ViewModel() {
//
//     fun insert(cookie: Cookie) {
//        viewModelScope.launch {
//            App.database.getCookieDao().insert(cookie)
//        }
//
//    }


}