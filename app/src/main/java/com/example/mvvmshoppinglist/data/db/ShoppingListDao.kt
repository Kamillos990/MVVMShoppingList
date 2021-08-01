package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList

@Dao
abstract class ShoppingListDao : BaseDao<ShoppingList>(){
    @Query("SELECT * FROM shopping_lists WHERE archive IS 0")
    abstract  fun getCurrentShoppingLists() : LiveData<List<ShoppingList>>

    @Query("SELECT * FROM shopping_lists WHERE archive IS 1")
    abstract fun getArchivedShoppingLists(): LiveData<List<ShoppingList>>

    @Query("SELECT * FROM shopping_lists")
    abstract fun getAllLists(): LiveData<List<ShoppingList>>
}