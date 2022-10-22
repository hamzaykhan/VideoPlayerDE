package com.silverorange.videoplayer.activities.video_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silverorange.videoplayer.data.model.Video
import com.silverorange.videoplayer.data.repository.Repository
import com.silverorange.videoplayer.wrappers.NoInternetException
import com.silverorange.videoplayer.wrappers.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class VideoInfoViewModel @Inject constructor(
    private val repository:  Repository
): ViewModel() {

    private val _uiState = MutableLiveData<VideoInfoUiState>()
    val uiState: LiveData<VideoInfoUiState>
        get() = _uiState

    private val _video = MutableLiveData<Video>()
    val video: LiveData<Video>
        get() = _video

    init {
        getVideo()
    }

    private fun getVideo() {
        viewModelScope.launch {
            repository.getFirstVideo().collect {
                when (it) {
                    Resource.Empty -> _uiState.value = Empty

                    Resource.Loading -> _uiState.value = Loading

                    is Resource.Success -> {
                        _video.value = it.data!!
                        _uiState.value = Content
                    }

                    is Resource.Error -> {
                        if (it.exception is NoInternetException)
                            _uiState.value = NoInternet
                        else
                            _uiState.value = NoServer
                    }
                }
            }
        }
    }
}