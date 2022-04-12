package com.myapplication.gitaday14.ui

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.myapplication.gitaday14.ui.database.CookieDataBase
import com.myapplication.gitaday14.ui.model.Cookies
import com.myapplication.gitaday14.ui.utils.getJsonDataFromAsset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataRepository {

//    private fun mapJsonToData(): Cookies {
//        val jsonFileString = getJsonDataFromAsset(requireContext(this), "cookiedata.json")
//        return Gson().fromJson(jsonFileString, Cookies::class.java)
//
//    }
//
//    private fun addInDatabase() {
//        val cookies = mapJsonToData().cookies
//        val db = CookieDataBase.invoke(this)
//        lifecycleScope.launch(Dispatchers.IO) {
//            val check = db.getCookieDao().exists(1)
//            if (!check) {
//                for (data in cookies) {
//                    db.getCookieDao().addCookie(data)
//                }
//            }
//        }
//    }
}