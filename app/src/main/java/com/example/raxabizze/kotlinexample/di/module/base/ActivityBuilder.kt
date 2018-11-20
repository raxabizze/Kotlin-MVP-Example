package com.example.raxabizze.kotlinexample.di.module.base

import com.example.raxabizze.kotlinexample.di.annotation.LoginScoped
import com.example.raxabizze.kotlinexample.di.module.LoginModule
import com.example.raxabizze.kotlinexample.di.module.StandardModule
import com.example.raxabizze.kotlinexample.ui.standard.StandardActivity
import com.example.raxabizze.kotlinexample.ui.forgot_password.ForgotPasswordActivity
import com.example.raxabizze.kotlinexample.ui.login.LoginActivity
import com.example.raxabizze.kotlinexample.ui.main.MainActivity
import com.example.raxabizze.kotlinexample.ui.navegation.NavegationActivity
import com.example.raxabizze.kotlinexample.ui.register.RegisterActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @LoginScoped
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginActivity (): LoginActivity

    @LoginScoped
    @ContributesAndroidInjector(modules = [StandardModule::class])
    abstract fun bindStandardActivity (): StandardActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity (): MainActivity

    @ContributesAndroidInjector
    abstract fun bindRegisterActivity (): RegisterActivity

    @ContributesAndroidInjector
    abstract fun bindForgotPasswordActivity (): ForgotPasswordActivity

    @ContributesAndroidInjector
    abstract fun bindNavegationActivity (): NavegationActivity
}