package com.dragon.mvvm.domain

class AddItemUseCase(private val ShopListRepository: ShopListRepository) {
    fun addItem(item: ShopItem){
        ShopListRepository.addItem(item)
    }

}