package com.dragon.mvvm.domain

class DeleteItemUseCase(private val ShopListRepository: ShopListRepository) {
    fun deleteItem(item: ShopItem){
        ShopListRepository.deleteItem(item)
    }
}