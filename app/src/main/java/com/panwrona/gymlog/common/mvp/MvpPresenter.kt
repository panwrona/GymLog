package com.panwrona.gymlog.common.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.*

abstract class MvpPresenter<V : MvpView> {

    protected var view: V? = null
    private var wasViewAttachedBefore = false
    private val commandQueue: Queue<UiCommand<V>> = LinkedList<UiCommand<V>>()
    private val disposables = CompositeDisposable()

    open fun attachView(view: V) {
        this.view = view
        executeUICommandQueue()
        if (!wasViewAttachedBefore) {
            onFirstViewAttachment()
            wasViewAttachedBefore = true
        }
    }

    protected fun Disposable.addDisposable() {
        disposables.add(this)
    }

    open protected fun onFirstViewAttachment() {}

    open fun detachView() {
        view = null
    }

    protected fun executeUICommand(command: UiCommand<V>) {
        commandQueue.add(command)
        executeUICommandQueue()
    }

    private fun executeUICommandQueue() {
        while (view != null) {
            commandQueue.poll()?.execute(view as V) ?: return
        }
    }

    open fun onDestroy() {
        for (i in commandQueue.indices) {
            commandQueue.remove()
        }
        disposables.dispose()
        wasViewAttachedBefore = false
    }

    fun onView(function: V.() -> Unit) {
        executeUICommand(object : UiCommand<V> {
            override fun execute(view: V) {
                function.invoke(view)
            }
        })
    }
}