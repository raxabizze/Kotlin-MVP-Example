package com.example.raxabizze.kotlinmvpexample.di.module.base

import android.content.Context
import com.example.raxabizze.kotlinmvpexample.App
import com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler.SchedulerProvider
import com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler.SchedulerProviderImp
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule
{
    @Provides
    @Singleton
    fun provideApplication(app : App) : Context = app

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = SchedulerProviderImp()


}