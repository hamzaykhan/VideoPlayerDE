package com.silverorange.videoplayer.di.module

import androidx.lifecycle.ViewModelProvider
import com.silverorange.videoplayer.di.factory.AppViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelsFactoryModule {
    @Binds
    fun bindAppViewModelFactory(factory: AppViewModelProviderFactory) : ViewModelProvider.Factory
}