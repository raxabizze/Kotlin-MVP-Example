package com.example.raxabizze.kotlinexample.di.component

import com.example.raxabizze.kotlinexample.App
import com.example.raxabizze.kotlinexample.di.module.base.FragmentBuilder
import com.example.raxabizze.kotlinexample.di.module.base.ActivityBuilder
import com.example.raxabizze.kotlinexample.di.module.base.AppModule
import com.example.raxabizze.kotlinexample.di.module.base.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class,
        ViewModelModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
    fun inject(app: App)
}