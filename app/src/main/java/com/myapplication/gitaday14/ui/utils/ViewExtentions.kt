package com.myapplication.gitaday14.ui.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.myapplication.gitaday14.R

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}


fun ImageView.loadImage(url: String) {
    if (url.isNullOrBlank()) {
        setImageResource(R.drawable.ic_launcher_foreground)
    } else {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .override(200, 200)
        .into(this) }
}