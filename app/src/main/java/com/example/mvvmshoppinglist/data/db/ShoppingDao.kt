package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.db.entities.relations.ListWithItems

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertItem(item : ShoppingItem)

    @Delete
    suspend fun deleteItem(item : ShoppingItem)

    @Query("DELETE FROM shopping_items")
    fun deleteAllShoppingItems()

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertList(list: ShoppingList)

    @Delete
    suspend fun deleteList(list: ShoppingList)

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE list_name = :list_name ")
    fun getAllShoppingItemsFromList(list_name: String) : LiveData<List<ListWithItems>>


}