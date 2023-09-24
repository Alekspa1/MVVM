package com.dragon.mvvm.domain

class СhangeItemUseCase(private val ShopListRepository: ShopListRepository) {
    fun changeItem(item: ShopItem){
        ShopListRepository.changeItem(item)
    }
}