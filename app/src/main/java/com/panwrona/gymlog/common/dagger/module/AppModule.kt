package com.panwrona.gymlog.common.dagger.module

import android.content.Context
import com.panwrona.gymlog.GymLogApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (private val application: GymLogApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = application
}