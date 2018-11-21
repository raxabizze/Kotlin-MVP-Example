package com.example.raxabizze.kotlinmvpexample.di.module

import com.example.raxabizze.kotlinmvpexample.di.annotation.TestScoped
import com.example.raxabizze.kotlinmvpexample.ui.login.LoginData
import dagger.Module
import dagger.Provides

@Module
@TestScoped
class TestModule {

    @Provides
    fun provideLoginData(): LoginData {
        return LoginData()
    }

}