package com.silverorange.videoplayer.di.module

import com.silverorange.videoplayer.data.remote.ApiService
import com.silverorange.videoplayer.data.repository.Repository
import com.silverorange.videoplayer.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun generateRepository(apiService: ApiService): Repository {
        return RepositoryImpl(apiService)
    }
}