package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingListViewModel(private val repository : ShoppingRepository) :ViewModel() {

    fun upsertList(list: ShoppingList) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(list)
    }

    fun deleteList(list: ShoppingList) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(list)
    }

    fun getCurrentShoppingLists() = repository.getCurrentShoppingLists()

    fun getArchivedShoppingLists() = repository.getArchivedShoppingLists()
}