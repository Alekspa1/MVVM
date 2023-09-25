package com.dragon.mvvm.domain

class ChangeItemUseCase(private val ShopListRepository: ShopListRepository) {
    fun changeItem(item: ShopItem){
        ShopListRepository.changeItem(item)
    }
}