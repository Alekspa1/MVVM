package com.dragon.mvvm.presentation


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dragon.mvvm.R
import com.dragon.mvvm.databinding.ShopListItemEnabledBinding
import com.dragon.mvvm.databinding.ShopListItemDisabledBinding
import com.dragon.mvvm.domain.ShopItem

class ShopListAdapter(
    private val onClickListener: OnClickListener, private val onLongClickListener: OnLongClickListener
) : ListAdapter<ShopItem, ShopListAdapter.Holder>(ShopListDifful()) {

    class Holder(val item: View) : RecyclerView.ViewHolder(item) {

        private fun act(): ShopListItemEnabledBinding {
            return ShopListItemEnabledBinding.bind(itemView)
        }

        private fun test(): ShopListItemDisabledBinding {
            return ShopListItemDisabledBinding.bind(itemView)
        }

        fun bind(
            shopItem: ShopItem,
            onClickListener: OnClickListener,
            onLongClickListener: OnLongClickListener
        ) {
            when (shopItem.enabled) {
                true -> {
                    act().tvName.text = shopItem.name
                    act().tvCurrent.text = shopItem.count.toString()
                }

                else -> {
                    test().tvName.text = shopItem.name
                    test().tvCurrent.text = shopItem.count.toString()
                }
            }
            itemView.setOnClickListener {
                onClickListener.onClick(shopItem.id)
            }
            itemView.setOnLongClickListener {
                onLongClickListener.onLongClick(shopItem)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return Holder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) R.layout.shop_list_item_enabled
        else R.layout.shop_list_item_disabled
    } // Возвращаем вью в зависимости от условия

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), onClickListener, onLongClickListener)
    }

    interface OnClickListener {
        fun onClick(id: Int)
    }

    interface OnLongClickListener {
        fun onLongClick(shopItem: ShopItem)
    }


}
