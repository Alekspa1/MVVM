package com.dragon.mvvm.presentation

import androidx.recyclerview.widget.DiffUtil
import com.dragon.mvvm.domain.ShopItem

class ShopListDifful: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}