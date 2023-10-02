package com.dragon.mvvm.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GetShopListUseCase(private val ShopListRepository: ShopListRepository) {
    fun getShopList(): MutableLiveData<List<ShopItem>> {
       return ShopListRepository.getShopList()
    }

}