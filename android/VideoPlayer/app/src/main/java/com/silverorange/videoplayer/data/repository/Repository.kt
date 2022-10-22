package com.silverorange.videoplayer.data.repository

import com.silverorange.videoplayer.data.mapper.VideoMapper
import com.silverorange.videoplayer.data.model.Video
import com.silverorange.videoplayer.data.remote.ApiService
import com.silverorange.videoplayer.ktx.stringToDate
import com.silverorange.videoplayer.wrappers.Resource
import com.silverorange.videoplayer.wrappers.callApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface Repository {
    suspend fun getFirstVideo(): Flow<Resource<Video>>
}

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
): Repository {

    override suspend fun getFirstVideo(): Flow<Resource<Video>>  = flow {
        emit(Resource.Loading)
        callApi {
            apiService.getVideos()
        }.apply {
            when (this) {
                is Resource.Success -> {
                    val data = data!!.sortedByDescending { it.publishedAt.stringToDate() }.map { response ->
                        VideoMapper.convertResponseToVideo(response)
                    }
                    emit(Resource.Success(data.first()))
                }

                is Resource.Error -> {
                    emit(Resource.Error(exception))
                }

                Resource.Empty -> {
                    emit(Resource.Empty)
                }
            }
        }
    }.flowOn(coroutineDispatcher)

}