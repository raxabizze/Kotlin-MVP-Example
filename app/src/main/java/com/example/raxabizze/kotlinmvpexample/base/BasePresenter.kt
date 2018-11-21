package com.example.raxabizze.kotlinmvpexample.base

import com.example.raxabizze.kotlinmvpexample.utils.api.PostApi
import com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BasePresenter<V : BaseView>: BaseAttacher<V> {

    lateinit var schedulerProvider : SchedulerProvider

    lateinit var mCompositeDisposable: CompositeDisposable

    lateinit var mPostApi: PostApi

    private var mView: V? = null

    @Inject
    fun BaseViewModel(mCompositeDisposable: CompositeDisposable, schedulerProvider: SchedulerProvider, mPostApi: PostApi){
        this.mCompositeDisposable = mCompositeDisposable
        this.schedulerProvider = schedulerProvider
        this.mPostApi = mPostApi
    }

    fun getView(): V? = mView

    override fun onAttached(view: V) {
        mView = view
    }

    override fun onDetached() {
        unSubscribe()
        mView = null
    }

    private fun unSubscribe() = mCompositeDisposable.dispose()
}