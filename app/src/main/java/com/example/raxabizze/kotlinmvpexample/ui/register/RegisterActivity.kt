package com.example.raxabizze.kotlinmvpexample.ui.register

import android.os.Bundle
import com.example.raxabizze.kotlinmvpexample.R
import com.example.raxabizze.kotlinmvpexample.base.BaseActivity
import com.example.raxabizze.kotlinmvpexample.utils.addFragment
import com.example.raxabizze.kotlinmvpexample.utils.toast

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        addFragment(TestFragment(), R.id.layout)

        toast("onCreate")
    }


}
