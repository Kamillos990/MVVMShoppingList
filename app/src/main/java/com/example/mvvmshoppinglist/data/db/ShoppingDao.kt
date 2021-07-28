package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query("DELETE FROM shopping_items")
    fun deleteAllShoppingItems()

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>
}