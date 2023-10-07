package com.dragon.mvvm.presentation


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
    private lateinit var launcher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if(result.resultCode == RESULT_OK) {
                val name = result.data?.getStringExtra(SET_NAME_SHOPITEM)
                val quantity = result.data?.getIntExtra(SET_QUANTITY_SHOPITEM, 0)
                val id = result.data?.getIntExtra(SET_ID_SHOPITEM, 0)
                viewModel.changeItem(ShopItem(name!!, quantity!!,true,id!!))
                Log.d("MyLog", name)
                Log.d("MyLog", quantity.toString())
                Log.d("MyLog", id.toString())
            }
        }
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
        launcher.launch(intent)
    }

    override fun onLongClick(shopItem: ShopItem) {
        viewModel.changeItem(shopItem)
    }
    companion object {
        const val SET_ID_SHOPITEM = "100"
        const val SET_NAME_SHOPITEM = "101"
        const val SET_QUANTITY_SHOPITEM = "102"
    }

        }

