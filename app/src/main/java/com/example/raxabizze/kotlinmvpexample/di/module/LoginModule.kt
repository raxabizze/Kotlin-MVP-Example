package com.example.raxabizze.kotlinmvpexample.di.module

import com.example.raxabizze.kotlinmvpexample.ui.login.LoginContract
import com.example.raxabizze.kotlinmvpexample.ui.login.LoginData
import com.example.raxabizze.kotlinmvpexample.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    internal fun providePresenter(presenter: LoginPresenter<LoginContract.View>)
            : LoginContract.Presenter<LoginContract.View> {
        return presenter
    }

    @Provides
    fun provideLoginData(): LoginData {
        return LoginData()
    }
}