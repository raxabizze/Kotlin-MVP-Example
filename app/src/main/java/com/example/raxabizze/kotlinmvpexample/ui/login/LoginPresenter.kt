package com.example.raxabizze.kotlinmvpexample.ui.login

import com.example.raxabizze.kotlinmvpexample.base.BasePresenter
import com.example.raxabizze.kotlinmvpexample.di.annotation.LoginScoped
import com.example.raxabizze.kotlinmvpexample.model.Repository
import com.example.raxabizze.kotlinmvpexample.model.data.GitRepoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@LoginScoped
class LoginPresenter<V : LoginContract.View> @Inject constructor(var gitRepoRepository: GitRepoRepository) :  BasePresenter<V>(), LoginContract.Presenter<V> {

    lateinit var disposable: Disposable

    override fun onLoadRepositories() {
        disposable = gitRepoRepository.
                getRepositories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableObserver<ArrayList<Repository>>() {

            override fun onError(e: Throwable) {
                getView()?.onLoadDataFailure()
            }

            override fun onNext(data: ArrayList<Repository>) {
                getView()?.onLoadDataSuccess(data)
            }

            override fun onComplete() {
            }
        })
    }
}
