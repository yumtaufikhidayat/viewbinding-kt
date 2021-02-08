package com.taufik.viewbindingkt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taufik.viewbindingkt.databinding.ItemLayoutBinding
import com.taufik.viewbindingkt.model.ItemBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val itemList = ArrayList<ItemBinding>()

    fun setDataList(itemBinding: ArrayList<ItemBinding>) {
        itemList.clear()
        itemBinding.addAll(itemBinding)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    inner class MyViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemBinding: ItemBinding) =
            with(binding){
                tvItemBinding.text = itemBinding.itemName
            }
    }
}