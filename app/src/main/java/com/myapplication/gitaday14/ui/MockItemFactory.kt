package com.myapplication.gitaday14.ui

import android.app.Application
import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.myapplication.gitaday14.ui.model.Cookie
import com.myapplication.gitaday14.ui.model.Cookies
import java.io.InputStream


class MockItemFactory(

    private val application: Application
) {

    companion object {
        const val KEY_FIRST_START = "FIRST_START"
    }


    fun generateMockList(): List<Cookie> {
        val response = application.assets.readAssetsFile("cookiedata.json")
        return GsonBuilder().create().fromJson(response, Array<Cookie>::class.java).asList()
    }

    private fun AssetManager.readAssetsFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }

}