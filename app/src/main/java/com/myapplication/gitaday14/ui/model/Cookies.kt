package com.myapplication.gitaday14.ui.model

import com.google.gson.annotations.SerializedName



data class Cookies(
    @SerializedName("cookies")
    val cookies: List<Cookie>
)