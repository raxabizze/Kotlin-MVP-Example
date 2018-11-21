package com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler

import io.reactivex.Scheduler


interface SchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler
}