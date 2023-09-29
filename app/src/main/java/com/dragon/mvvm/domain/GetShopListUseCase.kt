package com.dragon.mvvm.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val ShopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
       return ShopListRepository.getShopList()
    }

}