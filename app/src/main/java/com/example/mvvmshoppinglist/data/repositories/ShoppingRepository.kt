package com.example.mvvmshoppinglist.data.repositories

import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList


class ShoppingRepository(
    private val db : ShoppingDatabase
) {
    suspend fun upsert(item : ShoppingItem) = db.getShoppingDao().upsertItem(item)
    suspend fun delete(item: ShoppingItem) =  db.getShoppingDao().deleteItem(item)
    fun deleteAllFromTable() = db.getShoppingDao().deleteAllShoppingItems()
    fun getAllShoppingItemsFromList(id: Int) = db.getShoppingDao().getAllShoppingItemsFromList(id)
    suspend fun upsert(list : ShoppingList) = db.getShoppingDao().upsertList(list)
    suspend fun delete(list : ShoppingList) = db.getShoppingDao().deleteList(list)
    fun getAllShoppingLists() = db.getShoppingDao().getAllShoppingLists()
}