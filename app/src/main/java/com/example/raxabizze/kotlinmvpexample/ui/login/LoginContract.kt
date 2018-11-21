package com.example.raxabizze.kotlinmvpexample.ui.login

import android.arch.lifecycle.MutableLiveData
import com.example.raxabizze.kotlinmvpexample.base.BaseAttacher
import com.example.raxabizze.kotlinmvpexample.base.BaseView
import com.example.raxabizze.kotlinmvpexample.model.Repository

interface LoginContract {

    interface View : BaseView {

        fun onLoadDataClick()

        fun onLoadDataSuccess(repositories: ArrayList<Repository>)

        fun onLoadDataFailure()

        interface OnItemClickListener {
            fun onItemClick(position: Int)
        }
    }


    interface Presenter<V : View> : BaseAttacher<V>{

        fun onLoadRepositories()
    }

    interface Adapter {
        fun replaceData(arrayList: ArrayList<Repository>)
    }
}