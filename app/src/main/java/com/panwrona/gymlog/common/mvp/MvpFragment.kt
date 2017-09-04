package com.panwrona.gymlog.common.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class MvpFragment<V : MvpView, P : MvpPresenter<V>> : Fragment(), MvpView {

    @Inject protected lateinit var presenter : P
    abstract val layout: Int
    abstract fun getDependencies()

    private lateinit var parentView: MvpView
    private var fragmentView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parentView = activity as MvpView
        if (fragmentView == null) {
            fragmentView = inflater.inflate(layout, container, false)
            getDependencies()
        }
        return fragmentView
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this as V)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        fragmentView = null
        super.onDestroy()
    }
}

