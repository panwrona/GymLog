package com.panwrona.gymlog.common.mvp

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class MvpActivity<V : MvpView, P : MvpPresenter<V>> : AppCompatActivity(), MvpView {

    @Inject protected lateinit var presenter: P
    protected abstract val layout: Int

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        getDependencies()
        setContentView(layout)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    abstract fun getDependencies()

    override fun onStart() {
        super.onStart()
        presenter.attachView(this as V)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }
}