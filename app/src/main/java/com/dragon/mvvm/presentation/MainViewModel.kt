package com.dragon.mvvm.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dragon.mvvm.data.ShopListRepositoryIml
import com.dragon.mvvm.domain.ChangeItemUseCase
import com.dragon.mvvm.domain.DeleteItemUseCase
import com.dragon.mvvm.domain.GetItemIdUseCase
import com.dragon.mvvm.domain.GetShopListUseCase
import com.dragon.mvvm.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryIml
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val changeItemUseCase = ChangeItemUseCase(repository)
    private val getItemId = GetItemIdUseCase(repository)


    val shopList = getShopListUseCase.getShopList()


    fun deleteItem(item: ShopItem) {
        deleteItemUseCase.deleteItem(item)
    }

    fun changeItem(item: ShopItem) {
        val newItem = item.copy(enabled = !item.enabled)
        changeItemUseCase.changeItem(newItem)
    }
    fun getItemId(id:Int): ShopItem?{
        return getItemId.getItemId(id)
    }
}

