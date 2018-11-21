package com.example.raxabizze.kotlinmvpexample.ui.main

import android.util.Log
import com.example.raxabizze.kotlinmvpexample.base.BasePresenter
import com.example.raxabizze.kotlinmvpexample.di.annotation.MainScoped
import com.example.raxabizze.kotlinmvpexample.utils.api.PostApi
import com.example.raxabizze.kotlinmvpexample.utils.api.pojo.post.Post
import com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler.SchedulerProvider
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

@MainScoped
class MainPresenter<V : MainContract.View> @Inject constructor(var schedulerProvider: SchedulerProvider, var mPostApi: PostApi) :  BasePresenter<V>(), MainContract.Presenter<V> {


    override fun onLoadRepositories() {
//        val url = getView()?.getResourceString(R.string.api_request_todo, "200")

        /** method 1 **/
        addSubscribe(mPostApi.getPosts("/todos/")
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeWith(object : DisposableObserver<List<Post>>() {

                override fun onNext(@NonNull mDataList: List<Post>) {
                    getView()?.onLoadDataSuccess(mDataList)
                }

                override fun onError(@NonNull e: Throwable) {
                    getView()?.onLoadDataFailure()
                    Log.e("error", e.message)
                }

                override fun onComplete() {

                }
            }))


        /** method 2
        addSubscribe(mPostApi.getPosts("/todos/")
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(
                    { getView()?.onLoadDataSuccess(it) },
                    { getView()?.onLoadDataFailure() }
            ))
        **/
    }


}