package com.dragon.mvvm.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dragon.mvvm.R
import com.dragon.mvvm.data.Const
import com.dragon.mvvm.databinding.ActivityShopItemBinding
import com.dragon.mvvm.domain.ShopItem

class ActivityShopItem : AppCompatActivity() {
    private lateinit var binding: ActivityShopItemBinding
    private lateinit var viewModel: ShopItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityShopItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ShopItemViewModel()
        val itemId = intent.getIntExtra(Const.SET_ID_SHOPITEM, 0)
        val item = viewModel.getItemId(itemId)
        val flag = intent.getBooleanExtra(Const.ADD_ITEM, false)
       if(!flag){
           binding.editTextShopItem.setText("")
           binding.editTextShopItemQuantity.setText("")
       } else {
           binding.editTextShopItem.setText(item?.name)
           binding.editTextShopItemQuantity.setText(item?.count.toString())
       }
        binding.button.setOnClickListener {
            if (!flag){
                val name = binding.editTextShopItem.text.toString()
                val quanity = binding.editTextShopItemQuantity.text.toString().toInt()
                viewModel.addShopItem(ShopItem(name, quanity,false))
                finish()
            } else {
                val name = binding.editTextShopItem.text.toString()
                val quanity = binding.editTextShopItemQuantity.text.toString().toInt()
                viewModel.changeItemName(name, quanity, itemId)
                finish()
            }


        }
    }
}