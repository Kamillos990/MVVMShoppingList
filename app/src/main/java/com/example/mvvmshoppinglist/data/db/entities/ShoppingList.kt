package com.example.mvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_lists")
data class ShoppingList(
    @ColumnInfo(name="list_name")
    var list_name: String,
    @ColumnInfo(name="archive")
    var archive: Boolean
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}