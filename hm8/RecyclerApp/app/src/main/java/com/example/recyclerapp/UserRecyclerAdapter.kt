package com.example.recyclerapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.databinding.UserRecyclerItemBinding
import com.example.recyclerapp.model.Data

class UserRecyclerAdapter:RecyclerView.Adapter<UserRecyclerAdapter.VH>() {

    private val usersList:MutableList<Data> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView = UserRecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(usersList[position])
    }

    override fun getItemCount() = usersList.size

    inner class VH(val binding: UserRecyclerItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item : Data){
            with(binding){
                email.text = item.email
                firstName.text = item.first_name
                lastName.text = item.last_name
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUsersList(list:List<Data>){
        usersList.clear()
        usersList.addAll(list)
        notifyDataSetChanged()
    }
}