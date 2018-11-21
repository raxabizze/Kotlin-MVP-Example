package com.example.raxabizze.kotlinmvpexample.di.module

import com.example.raxabizze.kotlinmvpexample.di.annotation.MainScoped
import com.example.raxabizze.kotlinmvpexample.model.Repository
import com.example.raxabizze.kotlinmvpexample.ui.main.MainContract
import com.example.raxabizze.kotlinmvpexample.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
@MainScoped
class MainModule {

    @Provides
    internal fun providePresenter(presenter: MainPresenter<MainContract.View>)
            : MainContract.Presenter<MainContract.View> =  presenter

    @Provides
    internal fun provideRepository() : Repository = Repository("")
}