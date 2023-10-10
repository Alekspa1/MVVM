package com.dragon.mvvm.data

import android.content.Context
import android.content.Intent
import com.dragon.mvvm.presentation.ActivityShopItem

object Const {
    const val SET_ID_SHOPITEM = "100"
    const val ADD_ITEM = "103"
    const val NEW_ITEM = ""
    const val NEW_ITEM_COUNT = "1"

    fun addShopItem(context: Context): Intent{
        val intent = Intent(context, ActivityShopItem:: class.java)
        intent.putExtra(ADD_ITEM, false)
        return intent
    }
    fun editShopItem(context: Context, id: Int): Intent{
        val intent = Intent(context, ActivityShopItem:: class.java)
        intent.putExtra(ADD_ITEM, true)
        intent.putExtra(SET_ID_SHOPITEM, id)
        return intent
    }
}