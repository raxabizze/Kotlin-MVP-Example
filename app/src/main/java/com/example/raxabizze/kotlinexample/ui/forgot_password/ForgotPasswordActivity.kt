package com.example.raxabizze.kotlinexample.ui.forgot_password

import android.os.Bundle
import com.example.raxabizze.kotlinexample.R
import com.example.raxabizze.kotlinexample.base.BaseActivity
import com.example.raxabizze.kotlinexample.utils.addFragment
import com.example.raxabizze.kotlinexample.utils.toast

class ForgotPasswordActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        addFragment(TestFragment(), R.id.layout)
        toast("This is onCreate!!")
//        replaceFragment(TestFragment(), R.id.layout)
//        removeFragment(TestFragment())
    }


}
