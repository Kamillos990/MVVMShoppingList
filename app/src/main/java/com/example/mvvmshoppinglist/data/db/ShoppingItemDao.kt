package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem


@Dao
abstract class ShoppingItemDao : BaseDao<ShoppingItem>() {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun upsertItem(item : ShoppingItem) : Void
//
//    @Delete
//    suspend fun deleteItem(item : ShoppingItem) : Void
//
    @Query("SELECT * FROM shopping_items WHERE list_id LIKE :id")
    abstract fun getAllShoppingItemsFromList(id: Int) : LiveData<List<ShoppingItem>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun upsertList(list: ShoppingList) : Void
//
//    @Delete
//    suspend fun deleteList(list: ShoppingList) : Int
//

//

}