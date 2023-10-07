package com.dragon.mvvm.domain

import java.io.Serializable

class ChangeItemUseCase(private val ShopListRepository: ShopListRepository) {
    fun changeItem(item: ShopItem){
        ShopListRepository.changeItem(item)
    }
}