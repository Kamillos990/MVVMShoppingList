package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglist.other.ShoppingItemAdapter
import com.example.mvvmshoppinglist.ui.shoppinglist.dialogs.AddDialogListener
import com.example.mvvmshoppinglist.ui.shoppinglist.dialogs.AddShoppingItemDialog
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingListsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_lists)

    }
}
