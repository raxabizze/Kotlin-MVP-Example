package com.example.raxabizze.kotlinmvpexample.di.module.base

import android.arch.lifecycle.ViewModelProvider
import com.example.raxabizze.kotlinmvpexample.factory.AppViewModelFactory
import dagger.Binds
import dagger.Module


@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}
