package com.taufik.viewbindingkt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taufik.viewbindingkt.R
import com.taufik.viewbindingkt.databinding.ItemLayoutBinding

class MyAdapter(private val itemList: List<String>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val context: Context = holder.binding.root.context

        holder.binding.tvItemBinding.text = context.getString(R.string.tvRecyclerViewBinding)
    }

    override fun getItemCount(): Int = itemList.size
}