package com.example.raxabizze.kotlinmvpexample.di.module

import com.example.raxabizze.kotlinmvpexample.di.annotation.LoginScoped
import com.example.raxabizze.kotlinmvpexample.model.Repository
import com.example.raxabizze.kotlinmvpexample.ui.login.LoginContract
import com.example.raxabizze.kotlinmvpexample.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
@LoginScoped
class LoginModule {

    @Provides
    internal fun providePresenter(presenter: LoginPresenter<LoginContract.View>)
            : LoginContract.Presenter<LoginContract.View> {
        return presenter
    }

    @Provides
    internal fun provideRepository() : Repository {
        return Repository("")
    }
}