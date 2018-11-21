package com.example.raxabizze.kotlinmvpexample.ui.login

import com.example.raxabizze.kotlinmvpexample.base.BaseAttacher
import com.example.raxabizze.kotlinmvpexample.base.BaseView

interface LoginContract {

    interface View : BaseView {

        fun onRegisterClick()

        fun onSubmitClick()

        fun onLoginSuccess()
    }


    interface Presenter<V : View> : BaseAttacher<V>{
        fun onLoginCheck(account : String = "000", password : String = "000")
    }
}