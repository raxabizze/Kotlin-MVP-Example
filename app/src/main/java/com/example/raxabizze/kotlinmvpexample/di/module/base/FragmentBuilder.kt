package com.example.raxabizze.kotlinmvpexample.di.module.base

import com.example.raxabizze.kotlinmvpexample.di.module.TestModule
import com.example.raxabizze.kotlinmvpexample.ui.register.TestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = arrayOf(TestModule::class))
    abstract fun bindTestFragment (): TestFragment

}