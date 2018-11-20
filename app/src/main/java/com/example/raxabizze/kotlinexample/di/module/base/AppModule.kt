package com.example.raxabizze.kotlinexample.di.module.base

import android.content.Context
import com.example.raxabizze.kotlinexample.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule()
{
    @Provides
    @Singleton
    fun provideApplication(app : App) : Context = app
}