package com.dragon.mvvm.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        val item = viewModel.getItemId(intent)
        binding.editTextShopItem.setText(item?.name)
        binding.editTextShopItemQuantity.setText(item?.count.toString())
        binding.button.setOnClickListener {
            Log.d("MyLog","второе активити имя ${binding.editTextShopItem.text.toString()}")
            Log.d("MyLog",binding.editTextShopItemQuantity.text.toString())
            Log.d("MyLog",item?.id.toString())
            val i = Intent()
            i.putExtra("101", binding.editTextShopItem.text.toString())
            i.putExtra("102", binding.editTextShopItemQuantity.text.toString().toInt())
            i.putExtra("100", item?.id.toString().toInt())
            setResult(RESULT_OK, i)
            finish()
        }
    }
}