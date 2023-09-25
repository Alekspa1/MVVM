package com.dragon.mvvm.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dragon.mvvm.data.ShopListRepositoryIml
import com.dragon.mvvm.domain.AddItemUseCase
import com.dragon.mvvm.domain.ChangeItemUseCase
import com.dragon.mvvm.domain.DeleteItemUseCase
import com.dragon.mvvm.domain.GetShopListUseCase
import com.dragon.mvvm.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryIml
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val changeItemUseCase = ChangeItemUseCase(repository)
    private val addItemUseCase = AddItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()
    fun getShopList(){
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }
    fun deleteItem(item: ShopItem){
        deleteItemUseCase.deleteItem(item)
        getShopList()
    }
    fun addItem(item: ShopItem){
        addItemUseCase.addItem(item)
    }
}