package com.myapplication.gitaday14.ui.viewmodels

import androidx.lifecycle.*
import com.myapplication.gitaday14.ui.CookieRepository
import com.myapplication.gitaday14.ui.model.Cookie
import kotlinx.coroutines.launch

class FirstFragmentViewModel(private val repository: CookieRepository) : ViewModel() {
    private val allCookie: LiveData<List<Cookie>> = repository.allCookie.asLiveData().apply {
        mutableListOf<Cookie>()
    }
    val _allCookies: LiveData<List<Cookie>> = allCookie


    fun insert(cookie: Cookie) = viewModelScope.launch {
        repository.insert(cookie)
    }

}

class CookieViewModelFactory(private val repository: CookieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FirstFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}