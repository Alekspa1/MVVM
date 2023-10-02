package com.dragon.mvvm.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ShopListRepository {
    fun addItem(item: ShopItem)

    fun deleteItem(item: ShopItem)

    fun changeItem(item: ShopItem)

    fun getItemId(id: Int): ShopItem?

    fun getShopList(): MutableLiveData<List<ShopItem>>

}