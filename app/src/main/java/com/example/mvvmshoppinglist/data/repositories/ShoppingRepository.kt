package com.example.mvvmshoppinglist.data.repositories

import androidx.lifecycle.LiveData
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.db.entities.relations.ListWithItems

class ShoppingRepository(
    private val db : ShoppingDatabase
) {
    suspend fun upsert(item : ShoppingItem) = db.getShoppingDao().upsertItem(item)
    suspend fun delete(item: ShoppingItem) =  db.getShoppingDao().deleteItem(item)
    fun deleteAllFromTable() = db.getShoppingDao().deleteAllShoppingItems()
    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
    suspend fun upsert(list : ShoppingList) = db.getShoppingDao().upsertList(list)
    suspend fun delete(list : ShoppingList) = db.getShoppingDao().deleteList(list)
    fun getAllShoppingItemsFromList(list_name: String) = db.getShoppingDao().getAllShoppingItemsFromList(list_name)
}