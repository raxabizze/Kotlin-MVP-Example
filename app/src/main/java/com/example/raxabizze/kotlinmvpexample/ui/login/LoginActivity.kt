package com.example.raxabizze.kotlinmvpexample.ui.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.raxabizze.kotlinmvpexample.R
import com.example.raxabizze.kotlinmvpexample.base.BaseActivity
import com.example.raxabizze.kotlinmvpexample.model.Repository
import com.example.raxabizze.kotlinmvpexample.utils.toast
import javax.inject.Inject
import com.example.raxabizze.kotlinmvpexample.databinding.ActivityLoginBinding as Binding

class LoginActivity : BaseActivity(), LoginContract.View {

    lateinit var binding: Binding

    @Inject
    internal lateinit var mPresenter: LoginContract.Presenter<LoginContract.View>

    private val mAdapter = LoginAdapter(arrayListOf(), itemClickListener())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onSetUp()
    }

    private fun onSetUp() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.run {
            view = this@LoginActivity
            loading.visibility = View.INVISIBLE
            recyclerView.layoutManager = LinearLayoutManager(this@LoginActivity)
            recyclerView.adapter = mAdapter
        }

        mPresenter.onAttached(this)
    }

    override fun onLoadDataClick() {

        binding.loading.visibility = View.VISIBLE
        mPresenter.onLoadRepositories()
    }

    override fun onLoadDataFailure() {

        toast("onLoadDataFailure")
        binding.loading.visibility = View.INVISIBLE
    }

    override fun onLoadDataSuccess(repositories: ArrayList<Repository>) {

        toast("onLoadDataSuccess")
        mAdapter.replaceData(repositories)
        binding.loading.visibility = View.INVISIBLE
    }

    fun itemClickListener() = object: LoginContract.View.OnItemClickListener {

        override fun onItemClick(position: Int) {
            toast("onItemClick position: $position")
        }
    }
}