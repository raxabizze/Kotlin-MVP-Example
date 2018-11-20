package com.example.raxabizze.kotlinexample.di.module.base

import com.example.raxabizze.kotlinexample.di.module.TestModule
import com.example.raxabizze.kotlinexample.ui.forgot_password.TestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = arrayOf(TestModule::class))
    abstract fun bindTestFragment (): TestFragment

}