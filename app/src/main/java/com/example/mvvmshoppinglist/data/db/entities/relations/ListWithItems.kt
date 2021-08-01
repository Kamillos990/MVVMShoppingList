package com.example.mvvmshoppinglist.data.db.entities.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Relation
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList

@Entity(
    foreignKeys = [ForeignKey(entity = ShoppingList::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("list_id"),
    onDelete = ForeignKey.CASCADE)]
)

data class ListWithItems(
    @Embedded
    val list: ShoppingList,
    @Relation(
        parentColumn = "id",
        entityColumn = "list_id"
    )
    val items: List<ShoppingItem>
) {
}