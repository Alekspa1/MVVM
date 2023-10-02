package com.dragon.mvvm.data


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dragon.mvvm.domain.ShopItem
import com.dragon.mvvm.domain.ShopListRepository


object ShopListRepositoryIml : ShopListRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = arrayListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for(i in 0..10){
            addItem(ShopItem("name $i", i, true))
        }
    }

    override fun addItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINE_ID) {
            item.id = autoIncrementId++
        }
        shopList.add(item)
        update()
    }

    override fun deleteItem(item: ShopItem) {
        shopList.remove(item)
        update()
    }
    override fun changeItem(item: ShopItem) {
        val oldElement = getItemId(item.id)
        shopList.remove(oldElement)
        addItem(item)

    }
    override fun getItemId(id: Int): ShopItem? {
        return shopList.find { it.id == id }

    }

    override fun getShopList(): MutableLiveData<List<ShopItem>> {
        return shopListLD
    }
    private fun update(){
        shopListLD.value = shopList.toList()

    }



}