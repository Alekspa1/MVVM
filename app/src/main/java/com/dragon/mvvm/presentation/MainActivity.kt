package com.dragon.mvvm.presentation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dragon.mvvm.data.ShopListRepositoryIml


import com.dragon.mvvm.databinding.ActivityMainBinding
import com.dragon.mvvm.domain.ShopItem


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val shopIML = ShopListRepositoryIml


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.d("MyLog", it.toString())
        }
        binding.tvText.setOnClickListener {
            viewModel.shopList.observe(this){
                val item = shopIML.getItemId(86)
                if (item != null) {
                    binding.tvText.text = item.name
                } else
                    Toast.makeText(this, "Элемент $item не найден", Toast.LENGTH_SHORT).show()
            }
        }


        }
    }

