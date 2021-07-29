package com.example.mvvmshoppinglist.data.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList

@Database(
    entities = [ShoppingList::class, ShoppingItem::class],
    version = 1,
//    autoMigrations = [
//            AutoMigration (from = 1, to = 2)
//    ]
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao() : ShoppingDao

    companion object {

        @Volatile
        private var instance : ShoppingDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context : Context) = instance
            ?: synchronized(LOCK) {
                instance ?: createDatabase(context).also { instance = it }
            }

//        val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("CREATE TABLE Fruit (id INTEGER, name TEXT, " +
//                        "PRIMARY KEY(id))")}}

        private fun createDatabase(context : Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java,
                "ShoppingDB.db")
//                .addMigrations(MIGRATION_1_2)
                .build()
    }
}