package com.silverorange.videoplayer.activities.video_detail

sealed class VideoInfoUiState

object NoInternet: VideoInfoUiState()

object NoServer: VideoInfoUiState()

object Loading: VideoInfoUiState()

object Content: VideoInfoUiState()

object Empty: VideoInfoUiState()
