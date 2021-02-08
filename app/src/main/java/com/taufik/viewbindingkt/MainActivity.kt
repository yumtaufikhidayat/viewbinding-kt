package com.taufik.viewbindingkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.viewbindingkt.adapter.MyAdapter
import com.taufik.viewbindingkt.databinding.ActivityMainBinding
import com.taufik.viewbindingkt.model.ItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter
    private lateinit var dataList: ArrayList<ItemBinding>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()

        setListData()

        setRecyclerView()
    }

    private fun setAdapter() {
        
        myAdapter = MyAdapter()
        myAdapter.notifyDataSetChanged()
    }

    private fun setListData() {

        dataList = ArrayList()

        val list: MutableList<ItemBinding> = mutableListOf()

        list.add(ItemBinding("RecyclerView with View Binding Item 1"))
        list.add(ItemBinding("RecyclerView with View Binding Item 2"))
        list.add(ItemBinding("RecyclerView with View Binding Item 3"))
        list.add(ItemBinding("RecyclerView with View Binding Item 4"))
        list.add(ItemBinding("RecyclerView with View Binding Item 5"))

        dataList.addAll(list)
    }

    private fun setRecyclerView() {

        binding.apply {
            rvBinding.layoutManager = LinearLayoutManager(this@MainActivity)
            rvBinding.setHasFixedSize(true)
            myAdapter.setDataList(dataList)
            rvBinding.adapter = myAdapter
        }
    }
}