package com.dragon.mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dragon.mvvm.R
import com.dragon.mvvm.databinding.ActivityShopItemBinding

class ActivityShopItem : AppCompatActivity() {
    private lateinit var binding: ActivityShopItemBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityShopItemBinding.inflate(layoutInflater)
        viewModel = MainViewModel()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = intent.getIntExtra(MainActivity.SET_ID_SHOPITEM, 0)
        val res = viewModel.getItemId(intent)
        binding.textView.text = res?.name
    }
}