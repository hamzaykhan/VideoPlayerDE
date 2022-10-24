package com.silverorange.videoplayer.ktx

import android.view.View
import java.text.SimpleDateFormat
import java.util.Date

fun String.stringToDate(): Date {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(this)
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}