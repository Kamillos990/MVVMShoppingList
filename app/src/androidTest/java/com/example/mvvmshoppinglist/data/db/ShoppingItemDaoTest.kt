package com.example.mvvmshoppinglist.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValue
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.db.entities.ShoppingList
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingListDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ShoppingDatabase
    private lateinit var listDao: ShoppingListDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingDatabase::class.java
        ).allowMainThreadQueries().build()
        listDao = database.getShoppingListDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun upsertShoppingList() = runBlocking{
        val shoppingList = ShoppingList("name", false)
        listDao.upsert(shoppingList)

        val allShoppingLists = listDao.getCurrentShoppingLists().getOrAwaitValue()

        assertThat(allShoppingLists).contains(shoppingList)
    }

    @Test
    fun deleteShoppingList() = runBlocking {
        val shoppingList = ShoppingList("name", false)
        listDao.upsert(shoppingList)
        listDao.delete(shoppingList)

        val allShoppingLists = listDao.getAllLists().getOrAwaitValue()

        assertThat(allShoppingLists).doesNotContain(shoppingList)

    }


}