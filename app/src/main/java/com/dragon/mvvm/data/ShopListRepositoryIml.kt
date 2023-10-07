package com.dragon.mvvm.data



import androidx.lifecycle.MutableLiveData
import com.dragon.mvvm.domain.ShopItem
import com.dragon.mvvm.domain.ShopListRepository
import java.io.Serializable
import java.util.Random


object ShopListRepositoryIml : ShopListRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({ p0, p1 -> p0.id.compareTo(p1.id) })
    private var autoIncrementId = 0

    init {
        for(i in 0..10000){
            addItem(ShopItem("name $i", i, Random().nextBoolean()))
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