package com.example.raxabizze.kotlinmvpexample.base

interface BaseAttacher<V : BaseView> {

    fun onAttached(view: V)

    fun onDetached()
}