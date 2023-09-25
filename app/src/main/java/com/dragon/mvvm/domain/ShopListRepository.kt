package com.dragon.mvvm.domain

interface ShopListRepository {
    fun addItem(item: ShopItem)

    fun deleteItem(item: ShopItem)

    fun changeItem(item: ShopItem)

    fun getItemId(id: Int): ShopItem?

    fun getShopList(): List<ShopItem>

}