package com.dragon.mvvm.presentation

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
    fun changeItemName(name:String, count: Int, id: Int) {
        val oldItem = getItemId(id)
        val newItem = oldItem?.copy(name = name, count = count)
        if (newItem != null) {
            changeItemUseCase.changeItem(newItem)
        }
    }
    fun addShopItem(shopItem: ShopItem){
        addItemUseCase.addItem(shopItem)
    }

}