package com.silverorange.videoplayer.di.module

import androidx.lifecycle.ViewModel
import com.silverorange.videoplayer.activities.video_detail.VideoInfoViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.PROPERTY_GETTER
)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

/**
 * The Dagger Module for creating ViewModels based on the key-value Dagger bindings.
 * @author Hamza Khan
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(VideoInfoViewModel::class)
    abstract fun bindVideoInfoViewModel(viewModel: VideoInfoViewModel): ViewModel
}