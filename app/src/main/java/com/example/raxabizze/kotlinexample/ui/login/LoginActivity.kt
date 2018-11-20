package com.example.raxabizze.kotlinexample.ui.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import com.example.raxabizze.kotlinexample.R
import com.example.raxabizze.kotlinexample.base.BaseActivity
import com.example.raxabizze.kotlinexample.core.ActivityLauncher
import com.example.raxabizze.kotlinexample.ui.standard.StandardActivity
import com.example.raxabizze.kotlinexample.databinding.ActivityLoginBinding as Binding
import com.example.raxabizze.kotlinexample.ui.forgot_password.ForgotPasswordActivity
import com.example.raxabizze.kotlinexample.ui.main.MainActivity
import com.example.raxabizze.kotlinexample.ui.navegation.NavegationActivity
import com.example.raxabizze.kotlinexample.ui.register.RegisterActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    internal lateinit var mLoginData: LoginData

    @Inject
    internal lateinit var mPresenter1: LoginContract.Presenter<LoginContract.View>
    @Inject
    internal lateinit var mPresenter2: LoginContract.Presenter<LoginContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ActivityLauncher.go(this, NavegationActivity::class.java, null)

//        onSetUp()

//        repeat(100) { i ->
//            Log.e("gfbs", "sdgfss  $i")
//        }

        getNumber("") ?: getNumber("")

        println(getNumber("22.5") ?: "error in convert")



        var myList = listOf("5", "2", "4")

        myList.map(String::toUpperCase).sorted()
                .forEach(System.out::println)

        run(::onSetUp)

    }

    fun getNumber(str: String): Int? {
        return try {
            Integer.parseInt(str)
        }
        catch (e: NumberFormatException) {
            null
        }

    }


    private fun onSetUp() {
        var binding: Binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        mLoginData.account = "tt"
        binding.data = mLoginData
        binding.view = this

        Log.e("fdag","${mPresenter1 === mPresenter2}")
        //        mPresenter.onAttached(this)
    }

    override fun onSubmitClick() {
//        mPresenter.onLoginCheck(mLoginData.account, mLoginData.password)
    }

    override fun onRegisterClick() {
        ActivityLauncher.go(this, RegisterActivity::class.java, null)
    }

    override fun onCallBack() {
        ActivityLauncher.go(this, MainActivity::class.java, null)
    }

    override fun onStandardClick() {
        ActivityLauncher.go(this, StandardActivity::class.java, null)
    }

    override fun onForgotPasswordClick() {
        ActivityLauncher.go(this, ForgotPasswordActivity::class.java, null)
    }

}
