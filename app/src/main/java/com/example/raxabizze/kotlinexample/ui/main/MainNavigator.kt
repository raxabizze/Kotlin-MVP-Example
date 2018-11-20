package com.example.raxabizze.kotlinexample.ui.main

import android.app.Activity

interface MainNavigator {

    fun onChangeActivity(activity: Activity)

    fun onOpen()

    fun onClose()
}