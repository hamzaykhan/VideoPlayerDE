package com.silverorange.videoplayer.data.repository

import com.silverorange.videoplayer.data.remote.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface Repository {

}

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
): Repository {

}