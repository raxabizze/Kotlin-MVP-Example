package com.example.raxabizze.kotlinmvpexample.ui.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.raxabizze.kotlinmvpexample.R
import com.example.raxabizze.kotlinmvpexample.base.BaseActivity
import com.example.raxabizze.kotlinmvpexample.core.ActivityLauncher
import com.example.raxabizze.kotlinmvpexample.ui.register.RegisterActivity
import com.example.raxabizze.kotlinmvpexample.utils.toast
import javax.inject.Inject
import com.example.raxabizze.kotlinmvpexample.databinding.ActivityLoginBinding as Binding

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    internal lateinit var mLoginData: LoginData

    @Inject
    internal lateinit var mPresenter: LoginContract.Presenter<LoginContract.View>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        onSetUp()
    }

    private fun onSetUp() {
        mPresenter.onAttached(this)

        val binding: Binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.data = mLoginData
        binding.view = this
    }

    override fun onSubmitClick() {
        mPresenter.onLoginCheck()
    }

    override fun onLoginSuccess() =
        toast("onLoginSuccess ${1==1}")

    override fun onRegisterClick() =
        ActivityLauncher.go(this, RegisterActivity::class.java, null)
}