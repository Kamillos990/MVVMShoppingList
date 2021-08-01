package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class  ShoppingItemViewModel(
    private val repository : ShoppingRepository
) : ViewModel() {

    fun upsertItem(item : ShoppingItem) =  CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }

    fun deleteItem(item : ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }


    fun getAllShoppingItemsFromList(id: Int) = repository.getAllShoppingItemsFromList(id)
}