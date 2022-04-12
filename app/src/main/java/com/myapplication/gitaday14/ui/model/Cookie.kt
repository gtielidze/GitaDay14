package com.myapplication.gitaday14.ui.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.myapplication.gitaday14.ui.model.Cookie.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
@Keep
data class Cookie(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("flavour")
    val flavour: String = "",
    @SerializedName("expdate")
    val expDate: String = "",
    @SerializedName("brand")
    val brand: String = "",
    @SerializedName("weight")
    val weight: String = ""
) {
    companion object {
        const val TABLE_NAME = "cookie_detail"
    }
}