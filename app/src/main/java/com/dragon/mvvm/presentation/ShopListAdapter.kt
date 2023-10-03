package com.dragon.mvvm.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dragon.mvvm.R
import com.dragon.mvvm.databinding.ShopListItemBinding
import com.dragon.mvvm.domain.ShopItem

class ShopListAdapter(private val shopList: List<ShopItem>) : RecyclerView.Adapter<ShopListAdapter.Holder>() {

    class Holder(item: View) : RecyclerView.ViewHolder(item){
        val model = MainViewModel()
        val binding = ShopListItemBinding.bind(item)
        val context = item.context
        fun bind(shopItem: ShopItem) = with(binding){
            tvName.text = shopItem.name
            tvCurrent.text = shopItem.enabled.toString()
            when(shopItem.enabled) {
                true-> tvName.setTextColor(ContextCompat.getColor(context,R.color.red))
                false-> tvName.setTextColor(ContextCompat.getColor(context,R.color.green))
            }
            root.setOnClickListener{
                model.changeItem(shopItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shop_list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(shopList[position])
    }
}