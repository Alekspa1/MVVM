package com.dragon.mvvm.presentation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dragon.mvvm.data.ShopListRepositoryIml


import com.dragon.mvvm.databinding.ActivityMainBinding
import com.dragon.mvvm.domain.ShopItem


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val shopIML = ShopListRepositoryIml

    private lateinit var adapter: ShopListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val rcView = binding.rcView
        rcView.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            adapter = ShopListAdapter(it)
            rcView.adapter = adapter
        }

        }
    }

