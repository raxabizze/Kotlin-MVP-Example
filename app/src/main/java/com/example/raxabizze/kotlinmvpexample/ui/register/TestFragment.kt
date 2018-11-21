package com.example.raxabizze.kotlinmvpexample.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raxabizze.kotlinmvpexample.R
import com.example.raxabizze.kotlinmvpexample.base.BaseFragment
import com.example.raxabizze.kotlinmvpexample.ui.login.LoginData
import javax.inject.Inject
import android.util.Log as L

class TestFragment : BaseFragment() {
//    @Inject
//    internal lateinit var mLoginData: LoginData

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View = inflater.inflate(R.layout.fragment_register, container, false)
}
