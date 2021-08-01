package com.example.mvvmshoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.example.mvvmshoppinglist.data.db.entities.dao.ShoppingItemDao
import com.example.mvvmshoppinglist.data.db.entities.dao.ShoppingListDao

@Database(
    entities = [ShoppingList::class, ShoppingItem::class],
    version = 1,
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingItemDao() : ShoppingItemDao
    abstract fun getShoppingListDao() : ShoppingListDao

    companion object {

        @Volatile
        private var instance : ShoppingDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context : Context) = instance
            ?: synchronized(LOCK) {
                instance ?: createDatabase(context).also { instance = it }
            }


        private fun createDatabase(context : Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java,
                "ShoppingDB.db")
                .build()
    }
}