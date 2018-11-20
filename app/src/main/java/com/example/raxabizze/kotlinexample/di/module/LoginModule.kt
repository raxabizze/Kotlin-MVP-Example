package com.example.raxabizze.kotlinexample.di.module

import com.example.raxabizze.kotlinexample.ui.login.LoginContract
import com.example.raxabizze.kotlinexample.ui.login.LoginData
import com.example.raxabizze.kotlinexample.ui.login.LoginPresenter
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