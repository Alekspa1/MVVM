package com.dragon.mvvm.domain

class GetItemIdUseCase(private val ShopListRepository: ShopListRepository) {
    fun getItemId(id: Int): ShopItem{
        return ShopListRepository.getItemId(id)
    }
}