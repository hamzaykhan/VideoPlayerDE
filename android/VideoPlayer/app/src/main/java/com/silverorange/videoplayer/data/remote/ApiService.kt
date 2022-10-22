package com.silverorange.videoplayer.data.remote

import com.silverorange.videoplayer.data.response.VideoResponse
import retrofit2.http.GET

interface ApiService {

    @GET("videos/")
    suspend fun getVideos(): List<VideoResponse>

}