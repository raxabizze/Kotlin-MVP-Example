package com.example.raxabizze.kotlinmvpexample.di.module.base

import com.example.raxabizze.kotlinmvpexample.di.annotation.LoginScoped
import com.example.raxabizze.kotlinmvpexample.di.module.LoginModule
import com.example.raxabizze.kotlinmvpexample.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @LoginScoped
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginActivity (): LoginActivity
}