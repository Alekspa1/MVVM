package com.dragon.mvvm.domain

class GetItemIdUseCase(private val shopListRepository: ShopListRepository) {
    fun getItemId(id: Int): ShopItem? {
        return shopListRepository.getItemId(id)
    }
}