package com.dragon.mvvm.presentation


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.dragon.mvvm.databinding.ActivityMainBinding
import com.dragon.mvvm.domain.ShopItem


class MainActivity : AppCompatActivity(), ShopListAdapter.OnClickListener, ShopListAdapter.OnLongClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ShopListAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            adapter.submitList(it)
        }
        setRecyclerView()
        setSwipe()
    }

    private fun setSwipe() {
        val itemTouchHelperCallback =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val item = adapter.currentList[viewHolder.adapterPosition]
                    viewModel.deleteItem(item)
                }
            }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(binding.rcView)
    }

    private fun setRecyclerView() {
        val rcView = binding.rcView
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = ShopListAdapter(this@MainActivity, this@MainActivity)
        rcView.adapter = adapter
    }

    override fun onClick(id: Int) {
        val intent = Intent(this, ActivityShopItem::class.java)
        intent.putExtra(SET_ID_SHOPITEM, id)
        startActivity(intent)
    }

    override fun onLongClick(shopItem: ShopItem) {
        viewModel.changeItem(shopItem)
    }
    companion object {
        const val SET_ID_SHOPITEM = "100"
    }

        }

