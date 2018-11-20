package com.example.raxabizze.kotlinexample.base

interface BaseAttacher<V : BaseView> {

    fun onAttached(view: V)

    fun onDetached()
}