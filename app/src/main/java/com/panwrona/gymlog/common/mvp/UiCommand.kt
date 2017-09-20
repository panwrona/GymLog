package com.panwrona.gymlog.common.mvp

interface UiCommand<in T : MvpView> {
    fun execute(view: T)
}