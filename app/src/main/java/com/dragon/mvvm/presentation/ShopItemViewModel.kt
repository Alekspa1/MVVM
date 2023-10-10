package com.dragon.mvvm.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dragon.mvvm.data.ShopListRepositoryIml
import com.dragon.mvvm.domain.AddItemUseCase
import com.dragon.mvvm.domain.ChangeItemUseCase
import com.dragon.mvvm.domain.GetItemIdUseCase
import com.dragon.mvvm.domain.ShopItem

class ShopItemViewModel: ViewModel() {
    private val repository = ShopListRepositoryIml

    private val getItemId = GetItemIdUseCase(repository)
    private val changeItemUseCase = ChangeItemUseCase(repository)
    private val addItemUseCase = AddItemUseCase(repository)

    fun getItemId(id: Int): ShopItem? {
        return getItemId.getItemId(id)
    }
    fun changeItemName(name:String, count: String, id: Int) {
        val countChange = convertCount(count)
        val oldItem = getItemId(id)
        val newItem = oldItem!!.copy(name = name, count = countChange)
            changeItemUseCase.changeItem(newItem)

    }
    fun addShopItem(name: String, count: String){
        val countAdd = convertCount(count)
        val item = ShopItem(name, countAdd, false)
        addItemUseCase.addItem(item)
    }
    private fun convertCount(count: String): Int{
        return count.toInt()
    }

}