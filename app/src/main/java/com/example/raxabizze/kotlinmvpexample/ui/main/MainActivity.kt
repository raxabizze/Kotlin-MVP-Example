package com.example.raxabizze.kotlinmvpexample.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.raxabizze.kotlinmvpexample.R
import com.example.raxabizze.kotlinmvpexample.base.BaseActivity
import com.example.raxabizze.kotlinmvpexample.model.Repository
import com.example.raxabizze.kotlinmvpexample.utils.api.pojo.post.Post
import com.example.raxabizze.kotlinmvpexample.utils.toast
import javax.inject.Inject
import com.example.raxabizze.kotlinmvpexample.databinding.ActivityMainBinding as Binding

class MainActivity : BaseActivity(), MainContract.View {

    lateinit var binding: Binding

    @Inject
    lateinit var mRepository : Repository

    @Inject
    internal lateinit var mPresenter: MainContract.Presenter<MainContract.View>

    private val mAdapter = MainAdapter(arrayListOf(), itemClickListener())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onSetUp()
    }

    private fun onSetUp() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.run {
            view = this@MainActivity
            repository = mRepository
            loading.visibility = View.INVISIBLE
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = mAdapter
        }

        mPresenter.onAttached(this)
    }

    override fun onLoadDataClick() {

        binding.loading.visibility = View.VISIBLE
        mPresenter.onLoadRepositories()
        mRepository.status = "Loading ~"
    }

    override fun onLoadDataFailure() {

        toast("onLoadDataFailure")
        binding.loading.visibility = View.INVISIBLE
        mRepository.status = ""
    }

    override fun onLoadDataSuccess(mDataList: List<Post>) {

        toast("onLoadDataSuccess")
        mAdapter.replaceData(mDataList)
        binding.loading.visibility = View.INVISIBLE
        mRepository.status = ""
    }

    fun itemClickListener() = object: MainContract.View.OnItemClickListener {

        override fun onItemClick(position: Int) {
            toast("onItemClick position: $position")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDetached()
        super.onDestroy()
    }
}