package com.taufik.viewbindingkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.viewbindingkt.adapter.MyAdapter
import com.taufik.viewbindingkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()
    }

    private fun setRecyclerView() {

        binding.apply {
            rvBinding.layoutManager = LinearLayoutManager(this@MainActivity)
            rvBinding.setHasFixedSize(true)
            rvBinding.adapter = myAdapter
        }
    }
}