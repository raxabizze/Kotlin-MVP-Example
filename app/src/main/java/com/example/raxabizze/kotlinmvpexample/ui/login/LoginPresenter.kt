package com.example.raxabizze.kotlinmvpexample.ui.login

import android.util.Log
import com.example.raxabizze.kotlinmvpexample.base.BasePresenter
import com.example.raxabizze.kotlinmvpexample.di.annotation.LoginScoped
import javax.inject.Inject

@LoginScoped
class LoginPresenter<V : LoginContract.View> @Inject constructor() :  BasePresenter<V>(), LoginContract.Presenter<V> {

    @Inject
    internal lateinit var mLoginData: LoginData

    override fun onLoginCheck(account: String, password: String) {

        if (account == password) {
            getView()?.onLoginSuccess()
        }
    }


    override fun onAttached(view: V) {
        super.onAttached(view)

        mLoginData.account = "dsf"
        Log.e("sasasas", mLoginData.account)
    }
}
