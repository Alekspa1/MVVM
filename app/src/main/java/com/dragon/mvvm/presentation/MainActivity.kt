package com.dragon.mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dragon.mvvm.R
import com.dragon.mvvm.domain.AddItemUseCase
import com.dragon.mvvm.domain.GetShopListUseCase
import com.dragon.mvvm.domain.ShopListRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}