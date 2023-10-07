package com.dragon.mvvm.domain

import java.io.Serializable

data class ShopItem(
    val name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINE_ID
) : Serializable
{
    companion object{
        const val UNDEFINE_ID = -1
    }
}