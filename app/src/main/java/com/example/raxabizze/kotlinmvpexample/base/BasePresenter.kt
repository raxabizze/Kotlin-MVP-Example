package com.example.raxabizze.kotlinmvpexample.base

import com.example.raxabizze.kotlinmvpexample.network.PostApi
import com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

open class BasePresenter<V : BaseView>: BaseAttacher<V>{

    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mView : V? = null

    fun getView(): V? = mView

    override fun onAttached(view: V) {
        mView = view
    }

    override fun onDetached() {
        unSubscribe()
        mView = null
    }

    fun addSubscribe(disposable: Disposable) = mCompositeDisposable.add(disposable)

    private fun unSubscribe() = mCompositeDisposable.dispose()
}