package com.example.raxabizze.kotlinexample.base

abstract class BasePresenter<V : BaseView> : BaseAttacher<V>{
    private var mView : V? = null

    fun getView(): V? {
        return mView
    }

    override fun onAttached(view: V) {
        mView = view
    }

    override fun onDetached() {
        mView = null
    }
}