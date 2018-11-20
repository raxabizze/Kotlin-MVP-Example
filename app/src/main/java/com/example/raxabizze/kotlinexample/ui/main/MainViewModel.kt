package com.example.raxabizze.kotlinexample.ui.main

import android.util.Log
import com.example.raxabizze.kotlinexample.base.BaseViewModel
import com.example.raxabizze.kotlinexample.utils.NetManager
import javax.inject.Inject

    class MainViewModel @Inject constructor(var mNetManager : NetManager) : BaseViewModel<MainNavigator>() {

        fun onLatestNewsClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onScanClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onPushNotificationClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onBonusClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onSearchClick() {
            Log.e("net", mNetManager.isConnectedToInternet.toString())
            navigator.onChangeActivity(MainActivity())
        }

        fun onSettingClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onAuthorizedStoreClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onDiscountStoreClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onSignOutClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onUserGuideClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onCustomerServiceClick() {
            navigator.onChangeActivity(MainActivity())
        }

        fun onOpenClick() {
            navigator.onOpen()
        }

        fun onCloseClick() {
            navigator.onClose()
        }
}