package com.taufik.viewbindingkt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.taufik.viewbindingkt.databinding.ItemLayoutBinding
import com.taufik.viewbindingkt.model.ItemBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val itemList = ArrayList<ItemBinding>()

    fun setDataList(itemBinding: ArrayList<ItemBinding>) {
        itemList.clear()
        itemList.addAll(itemBinding)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val pos = itemList[position]
        holder.bind(pos)
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, " ${pos.itemName}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = itemList.size

    inner class MyViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemBinding: ItemBinding) =
            with(binding){
                tvItemBinding.text = itemBinding.itemName
            }
    }
}