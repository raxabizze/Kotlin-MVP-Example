package com.example.raxabizze.kotlinexample.di.module

import com.example.raxabizze.kotlinexample.di.annotation.TestScoped
import com.example.raxabizze.kotlinexample.ui.login.LoginData
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