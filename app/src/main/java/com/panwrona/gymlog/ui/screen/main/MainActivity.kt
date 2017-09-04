package com.panwrona.gymlog.ui.screen.main

import com.panwrona.gymlog.GymLogApp
import com.panwrona.gymlog.R
import com.panwrona.gymlog.common.mvp.MvpActivity
import com.panwrona.gymlog.common.mvp.MvpView

class MainActivity: MvpActivity<MainView, MainPresenter>(), MainView {
    override val layout = R.layout.activity_main
    override fun getDependencies() = GymLogApp.appComponent.inject(this)
}

interface MainView: MvpView
