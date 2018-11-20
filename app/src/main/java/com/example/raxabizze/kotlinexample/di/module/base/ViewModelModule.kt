package com.example.raxabizze.kotlinexample.di.module.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.raxabizze.kotlinexample.di.annotation.base.ViewModelKey
import com.example.raxabizze.kotlinexample.factory.AppViewModelFactory
import com.example.raxabizze.kotlinexample.ui.standard.StandardViewModel
import com.example.raxabizze.kotlinexample.ui.main.MainViewModel
import com.example.raxabizze.kotlinexample.ui.register.RegisterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    internal abstract fun bindRegisterActivityViewModel(registerViewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StandardViewModel::class)
    internal abstract fun bindStandardActivityViewModel(standardViewModel: StandardViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}
