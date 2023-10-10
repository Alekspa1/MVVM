package com.dragon.mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.dragon.mvvm.data.Const
import com.dragon.mvvm.data.Const.ADD_ITEM
import com.dragon.mvvm.data.Const.SET_ID_SHOPITEM
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
        val itemId = intent.getIntExtra(SET_ID_SHOPITEM, ShopItem.UNDEFINE_ID)
        val item = viewModel.getItemId(itemId)
        val flag = intent.getBooleanExtra(ADD_ITEM, false)
        if(flag) inputType(item!!.name, item.count.toString())

        binding.button.setOnClickListener {
            val name = binding.editTextShopItem.text.toString().trim()
            val quanity = binding.editTextShopItemQuantity.text.toString().trim()
            if (validate(name, quanity)) {
                if (!flag) {
                    viewModel.addShopItem(name, quanity)
                    finish()
                } else {
                    viewModel.changeItemName(name, quanity, itemId)
                    finish()
                }
            }

        }
    }

    private fun validate(name: String, quanity: String): Boolean {
        var result = true
        if (name.isEmpty()) {
            result = false
            binding.filledTextFieldShopItem.error = "Поле должно быть заполнено"
            binding.editTextShopItem.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    binding.filledTextFieldShopItem.error = null
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
        }

        if (quanity.isEmpty()) {
            result = false
            binding.filledShopItemQuantity.error = "Поле должно быть заполнено"
            binding.editTextShopItemQuantity.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    binding.filledShopItemQuantity.error = null
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
        } else if(quanity.toInt() <=0){
            result = false
            binding.filledShopItemQuantity.error = "Число должно быть больше 0"
            binding.editTextShopItemQuantity.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    binding.filledShopItemQuantity.error = null
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
        }

        return result

    } // проверяет корректность введеных данных

    private fun inputType(name: String, quanity: String) {
        binding.editTextShopItem.setText(name)
        binding.editTextShopItemQuantity.setText(quanity)
    } // устанавливает поля для ввода


}