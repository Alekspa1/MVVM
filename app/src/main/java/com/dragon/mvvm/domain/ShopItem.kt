package com.dragon.mvvm.domain

data class ShopItem(
    val name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINE_ID
)
{
    companion object{
        const val UNDEFINE_ID = -1
    }
}