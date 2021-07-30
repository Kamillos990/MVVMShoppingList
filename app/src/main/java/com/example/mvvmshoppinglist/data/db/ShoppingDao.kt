package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList


@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertItem(item : ShoppingItem)

    @Delete
    suspend fun deleteItem(item : ShoppingItem)

    @Query("DELETE FROM shopping_items")
    fun deleteAllShoppingItems()

    @Query("SELECT * FROM shopping_items WHERE list_id LIKE :id")
    fun getAllShoppingItemsFromList(id: Int) : LiveData<List<ShoppingItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertList(list: ShoppingList)

    @Delete
    suspend fun deleteList(list: ShoppingList)

    @Query("SELECT * FROM shopping_lists")
    fun getAllShoppingLists() : LiveData<List<ShoppingList>>


}