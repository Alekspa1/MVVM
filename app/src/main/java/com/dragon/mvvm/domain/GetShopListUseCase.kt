package com.dragon.mvvm.domain

class GetShopListUseCase(private val ShopListRepository: ShopListRepository) {
    fun getShopList(): List<ShopItem>{
       return ShopListRepository.getShopList()
    }

}