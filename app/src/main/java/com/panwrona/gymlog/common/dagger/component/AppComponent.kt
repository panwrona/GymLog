package com.panwrona.gymlog.common.dagger.component

import com.panwrona.gymlog.common.dagger.module.AppModule
import com.panwrona.gymlog.ui.screen.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}