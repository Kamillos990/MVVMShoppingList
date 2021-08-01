package com.example.mvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem (
    @ColumnInfo(name = "item_name")
    var name : String,
    @ColumnInfo(name = "item_amount")
    var amount : Int,
    @ColumnInfo(name = "checked")
    var isChecked : Boolean,
    @ColumnInfo(name = "list_id")
    var list_id: Int

){
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}