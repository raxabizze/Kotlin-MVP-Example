package com.example.raxabizze.kotlinmvpexample.ui.login

import android.util.Log
import com.example.raxabizze.kotlinmvpexample.R
import com.example.raxabizze.kotlinmvpexample.base.BasePresenter
import com.example.raxabizze.kotlinmvpexample.di.annotation.LoginScoped
import com.example.raxabizze.kotlinmvpexample.network.PostApi
import com.example.raxabizze.kotlinmvpexample.utils.BASE_URL
import com.example.raxabizze.kotlinmvpexample.utils.api.pojo.post.Post
import com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler.SchedulerProvider
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

@LoginScoped
class LoginPresenter<V : LoginContract.View> @Inject constructor(var schedulerProvider: SchedulerProvider, var mPostApi: PostApi) :  BasePresenter<V>() , LoginContract.Presenter<V> {


    override fun onLoadRepositories() {
//        val url = getView()?.getResourceString(R.string.api_request_todo, "200")


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
    }
}
