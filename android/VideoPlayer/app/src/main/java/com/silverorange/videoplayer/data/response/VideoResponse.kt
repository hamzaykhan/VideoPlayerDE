package com.silverorange.videoplayer.data.response

data class VideoResponse(
    val id: String,
    val title: String,
    val hlsURL: String,
    val fullURL: String,
    val description: String,
    val publishedAt: String,
    val author: AuthorResponse
)
