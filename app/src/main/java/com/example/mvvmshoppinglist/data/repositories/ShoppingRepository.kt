package com.example.mvvmshoppinglist.data.repositories

import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList


class ShoppingRepository(
    private val db : ShoppingDatabase
) {
    suspend fun upsert(item : ShoppingItem) = db.getShoppingItemDao().upsert(item)
    suspend fun delete(item: ShoppingItem) =  db.getShoppingItemDao().delete(item)
    fun getAllShoppingItemsFromList(id: Int) = db.getShoppingItemDao().getAllShoppingItemsFromList(id)
    suspend fun upsert(list : ShoppingList) = db.getShoppingListDao().upsert(list)
    suspend fun delete(list : ShoppingList) = db.getShoppingListDao().delete(list)
    fun getCurrentShoppingLists() = db.getShoppingListDao().getCurrentShoppingLists()
    fun getArchivedShoppingLists() = db.getShoppingListDao().getArchivedShoppingLists()
}