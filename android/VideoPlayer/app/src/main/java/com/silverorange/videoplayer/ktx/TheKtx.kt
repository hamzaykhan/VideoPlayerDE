package com.silverorange.videoplayer.ktx

import java.text.SimpleDateFormat
import java.util.Date

fun String.stringToDate(): Date {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(this)
}