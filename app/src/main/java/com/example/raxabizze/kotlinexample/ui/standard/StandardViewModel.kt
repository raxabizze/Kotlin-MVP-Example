package com.example.raxabizze.kotlinexample.ui.standard

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.example.raxabizze.kotlinexample.base.BaseViewModel
import com.example.raxabizze.kotlinexample.model.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import com.example.raxabizze.kotlinexample.model.data.GitRepoRepository
import plusAssign
import javax.inject.Inject

class StandardViewModel @Inject constructor(var gitRepoRepository: GitRepoRepository) : BaseViewModel<StandardNavigator>() {


    val text = ObservableField("old data")

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    private val compositeDisposable = CompositeDisposable()

    fun loadRepositories() {
        isLoading.set(true)
        compositeDisposable += gitRepoRepository
                .getRepositories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ArrayList<Repository>>() {

            override fun onError(e: Throwable) {
                //if some error happens in our data layer our app will not crash, we will
                // get error here
            }

            override fun onNext(data: ArrayList<Repository>) {
                repositories.value = data
            }

            override fun onComplete() {
                isLoading.set(false)
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}