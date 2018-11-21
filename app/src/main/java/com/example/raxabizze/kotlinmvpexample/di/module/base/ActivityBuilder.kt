package com.example.raxabizze.kotlinmvpexample.di.module.base

import com.example.raxabizze.kotlinmvpexample.di.annotation.MainScoped
import com.example.raxabizze.kotlinmvpexample.di.module.MainModule
import com.example.raxabizze.kotlinmvpexample.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @MainScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity (): MainActivity
}