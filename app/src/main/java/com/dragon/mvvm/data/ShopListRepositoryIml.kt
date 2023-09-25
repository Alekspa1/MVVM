package com.dragon.mvvm.data


import com.dragon.mvvm.domain.ShopItem
import com.dragon.mvvm.domain.ShopListRepository


object ShopListRepositoryIml : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0
    override fun addItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINE_ID) {
            item.id = autoIncrementId++
        }
        shopList.add(item)
    }

    override fun deleteItem(item: ShopItem) {
        shopList.remove(item)
    }
    override fun changeItem(item: ShopItem) {
        val oldElement = getItemId(item.id)
        shopList.remove(oldElement)
        addItem(item)
    }
    override fun getItemId(id: Int): ShopItem? {
        return shopList.find { it.id == id }

    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }


}