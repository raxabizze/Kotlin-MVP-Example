package com.example.raxabizze.kotlinexample.ui.login

import com.example.raxabizze.kotlinexample.base.BaseAttacher
import com.example.raxabizze.kotlinexample.base.BaseView

interface LoginContract {

    interface View : BaseView {
        fun onRegisterClick()

        fun onSubmitClick()

        fun onStandardClick()

        fun onForgotPasswordClick()

        fun onCallBack()
    }


    interface Presenter<V : View> : BaseAttacher<V>{
        fun onLoginCheck(account : String = "000", password : String = "000")
    }
}