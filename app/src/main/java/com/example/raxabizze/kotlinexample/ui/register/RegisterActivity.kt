package com.example.raxabizze.kotlinexample.ui.register

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.raxabizze.kotlinexample.R
import com.example.raxabizze.kotlinexample.base.BaseActivity
import com.example.raxabizze.kotlinexample.databinding.ActivityRegisterBinding
import com.example.raxabizze.kotlinexample.factory.AppViewModelFactory
import javax.inject.Inject

class RegisterActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory : AppViewModelFactory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(RegisterViewModel::class.java) }

    lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.viewModel = viewModel


        val list = mutableListOf("Hello")
        list.add("another string")
        list.printCollection()
    }

    fun <T> List<T>.printCollection() {
        for (item in this) {
            println(item)
        }
    }
}
