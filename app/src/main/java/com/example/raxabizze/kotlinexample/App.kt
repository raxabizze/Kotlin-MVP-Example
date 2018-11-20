package com.example.raxabizze.kotlinexample

import android.app.Activity
import android.app.Application
import com.example.raxabizze.kotlinexample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
//    @Inject
//    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

//    fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}