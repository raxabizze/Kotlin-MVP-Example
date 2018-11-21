package com.example.raxabizze.kotlinmvpexample.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.raxabizze.kotlinmvpexample.BR

class Repository(status : String) : BaseObservable(){

    @get:Bindable
    var status : String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.status)
    }
}