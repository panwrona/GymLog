package com.panwrona.gymlog

import android.app.Application
import com.panwrona.gymlog.common.dagger.component.AppComponent
import com.panwrona.gymlog.common.dagger.component.DaggerAppComponent
import com.panwrona.gymlog.common.dagger.module.AppModule

class GymLogApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
        lateinit var instance: GymLogApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}