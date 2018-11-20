package com.example.raxabizze.kotlinexample.ui.register

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View
import com.example.raxabizze.kotlinexample.core.ActivityLauncher
import com.example.raxabizze.kotlinexample.ui.main.MainActivity
import javax.inject.Inject

class RegisterViewModel @Inject constructor() : ViewModel() {
    var account : ObservableField<String> = ObservableField("")


    fun onSubmitClick(view : View) {
        ActivityLauncher.go(view.context, MainActivity::class.java, null)
    }
}