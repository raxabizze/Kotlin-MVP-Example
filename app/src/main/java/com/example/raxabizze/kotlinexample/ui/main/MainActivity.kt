package com.example.raxabizze.kotlinexample.ui.main

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Gravity
import com.example.raxabizze.kotlinexample.R
import com.example.raxabizze.kotlinexample.base.BaseActivity
import com.example.raxabizze.kotlinexample.core.ActivityLauncher
import com.example.raxabizze.kotlinexample.databinding.ActivityMainBinding
import com.example.raxabizze.kotlinexample.factory.AppViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity(), MainNavigator {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java) }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel

        viewModel.navigator = this


        /** 1 */
        val seasons = arrayOf("spring", "summer", "winter", "fall")
        seasons.forEach { println(it) }
        seasons.forEachIndexed { index, value -> println("$index  $value") }

        /** 1 */
        for (i in 1..3) {
            jloop@ for (j in 1..4) {
                for (k in 5..10) {
                    if (k == 7) continue@jloop
                }
            }
        }
    }

    override fun onClose() {
//        binding.drawerLayout.closeDrawer(Gravity.RIGHT)
    }

    override fun onOpen() {
//        binding.drawerLayout.openDrawer(Gravity.RIGHT)
    }

    override fun onChangeActivity(activity: Activity) {
        ActivityLauncher.go(this, activity::class.java, null)
    }
}
