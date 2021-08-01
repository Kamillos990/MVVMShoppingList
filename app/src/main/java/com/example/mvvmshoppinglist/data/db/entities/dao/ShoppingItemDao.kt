package com.example.mvvmshoppinglist.data.db.entities.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.dao.BaseDao


@Dao
abstract class ShoppingItemDao : BaseDao<ShoppingItem>() {


    @Query("SELECT * FROM shopping_items WHERE list_id LIKE :id")
    abstract fun getAllShoppingItemsFromList(id: Int) : LiveData<List<ShoppingItem>>

}