package com.example.raxabizze.kotlinmvpexample.di.component

import com.example.raxabizze.kotlinmvpexample.App
import com.example.raxabizze.kotlinmvpexample.di.module.base.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ApiModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,  //remove this line when add a fragment
        ServiceBuilderModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
    fun inject(app: App)
}