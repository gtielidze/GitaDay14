package com.myapplication.gitaday14.ui.utils

import android.app.Application
import android.content.Context
import java.io.IOException
import java.io.InputStream


fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}



