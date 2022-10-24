package com.silverorange.videoplayer.di.module

import com.silverorange.videoplayer.activities.video_detail.VideoInfoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindVideoInfoActivity(): VideoInfoActivity
}