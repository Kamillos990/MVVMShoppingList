package com.example.mvvmshoppinglist.ui.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglist.other.ShoppingListAdapter
import com.example.mvvmshoppinglist.ui.shoppinglist.dialogs.CreateDialogListener
import com.example.mvvmshoppinglist.ui.shoppinglist.dialogs.CreateShoppingListDialog
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingListsActivity : AppCompatActivity(),  ShoppingListAdapter.OnItemClickListener{

    lateinit var lists : List<ShoppingList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingListViewModel::class.java)

        val adapter = ShoppingListAdapter(listOf(),this)


        rvShoppingLists.layoutManager = LinearLayoutManager(this)
        rvShoppingLists.adapter = adapter


        viewModel.getAllShoppingLists().observe(this, Observer {
            adapter.lists = it
            adapter.notifyDataSetChanged()
            this.lists = it
        })

        fabList.setOnClickListener{
            CreateShoppingListDialog(this,
                object: CreateDialogListener {
                    override fun onCreateButtonClicked(list: ShoppingList) {
                        viewModel.upsertList(list)
                    }
                }).show()
        }
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this@ShoppingListsActivity, ShoppingItemActivity::class.java).apply {
            putExtra(getString(R.string.list_id), lists[position].id)
            putExtra(getString(R.string.list_name), lists[position].list_name)

        }
        startActivity(intent)
    }
}


