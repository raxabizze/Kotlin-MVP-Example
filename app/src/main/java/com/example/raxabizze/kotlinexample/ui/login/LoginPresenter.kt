package com.example.raxabizze.kotlinexample.ui.login

import android.util.Log
import com.example.raxabizze.kotlinexample.base.BasePresenter
import com.example.raxabizze.kotlinexample.di.annotation.LoginScoped
import javax.inject.Inject

@LoginScoped
class LoginPresenter<V : LoginContract.View> @Inject constructor() :  BasePresenter<V>(), LoginContract.Presenter<V> {

    override fun onLoginCheck(account: String, password: String) {
        if (account == password) {
            getView()?.onCallBack()
        }
    }

    @Inject
    internal lateinit var mLoginData: LoginData



    override fun onAttached(view: V) {
        super.onAttached(view)

        mLoginData.account = "dsf"
        Log.e("sasasas", mLoginData.account)
    }
}
