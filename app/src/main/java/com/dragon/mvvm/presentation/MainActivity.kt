package com.dragon.mvvm.presentation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.dragon.mvvm.databinding.ActivityMainBinding
import com.dragon.mvvm.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.addItem(ShopItem("",23,true))

        viewModel.shopList.observe(this){
            Log.d("MyLog", it.toString())
            //binding.tvText.text = it[0].count.toString()
        }
        viewModel.getShopList()
        binding.tvText.setOnClickListener {
            viewModel.deleteItem(ShopItem("",23,true,0))
            viewModel.shopList.observe(this){
                Log.d("MyLog", it.toString())
            }
            }

        }
    }

