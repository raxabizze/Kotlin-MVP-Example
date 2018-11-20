package com.example.raxabizze.kotlinexample.ui.standard

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.raxabizze.kotlinexample.R
import com.example.raxabizze.kotlinexample.base.BaseActivity
import com.example.raxabizze.kotlinexample.databinding.ActivityStandardBinding
import com.example.raxabizze.kotlinexample.factory.AppViewModelFactory
import com.example.raxabizze.kotlinexample.model.Repository
import javax.inject.Inject

class StandardActivity : BaseActivity(), StandardAdapter.OnItemClickListener, StandardNavigator {

    private lateinit var binding: ActivityStandardBinding
    private val repositoryRecyclerViewAdapter = StandardAdapter(arrayListOf(), this)
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(StandardViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_standard)

        viewModel.navigator = this

        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this,
                Observer<ArrayList<Repository>> { it?.let { repositoryRecyclerViewAdapter.replaceData(it) } })

    }

    override fun onItemClick(position: Int) {
        Log.e("onItemClick", position.toString())
    }
}
