package com.example.raxabizze.kotlinmvpexample.ui.login

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.raxabizze.kotlinmvpexample.databinding.ItemLoginBinding
import com.example.raxabizze.kotlinmvpexample.model.Repository

class LoginAdapter(private var items: ArrayList<Repository>,
                   private var listener: LoginContract.View.OnItemClickListener)
    : RecyclerView.Adapter<LoginAdapter.ViewHolder>(), LoginContract.Adapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLoginBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    override fun replaceData(arrayList: ArrayList<Repository>) {
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: ItemLoginBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, listener: LoginContract.View.OnItemClickListener?) {
            binding.repository = repo
            if (listener != null) {
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition) }
            }

            binding.executePendingBindings()
        }
    }

}

