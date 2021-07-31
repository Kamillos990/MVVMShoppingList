package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglist.other.ShoppingArchivedItemAdapter
import com.example.mvvmshoppinglist.other.ShoppingCurrentItemAdapter
import kotlinx.android.synthetic.main.activity_current_shopping_item.*



class ShoppingArchivedItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archived_shopping_item)



        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingItemViewModel::class.java)

        val adapter = ShoppingArchivedItemAdapter(listOf(), viewModel)
        val id = intent.getIntExtra(getString(R.string.list_id),-1)



        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter


        viewModel.getAllShoppingItemsFromList(id).observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()

        })

//        fabItem.setOnClickListener{
//            AddShoppingItemDialog(this,id,
//                object: AddDialogListener {
//                    override fun onAddButtonClicked(item: ShoppingItem) {
//                        viewModel.upsertItem(item)
//                    }
//                }).show()
//        }
    }
}
