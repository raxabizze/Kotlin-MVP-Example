package com.example.raxabizze.kotlinmvpexample.di.module.base

import com.example.raxabizze.kotlinmvpexample.service.MainIntentService
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ServiceBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainIntentService(): MainIntentService

}