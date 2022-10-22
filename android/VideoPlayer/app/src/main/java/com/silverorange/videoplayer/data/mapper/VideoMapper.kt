package com.silverorange.videoplayer.data.mapper

import com.silverorange.videoplayer.data.model.Video
import com.silverorange.videoplayer.data.response.VideoResponse

object VideoMapper {

    fun convertResponseToVideo(videoResponse: VideoResponse): Video {
        return Video(
            title = videoResponse.title,
            url = videoResponse.hlsURL,
            description = videoResponse.description,
            authorName = videoResponse.author.name
        )
    }

}