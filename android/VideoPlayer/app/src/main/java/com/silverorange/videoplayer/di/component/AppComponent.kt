package com.silverorange.videoplayer.di.component

import android.app.Application
import com.silverorange.videoplayer.VideoPlayerDE
import com.silverorange.videoplayer.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ViewModelsFactoryModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent: AndroidInjector<VideoPlayerDE> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: VideoPlayerDE)
}