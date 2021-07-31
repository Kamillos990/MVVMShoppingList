package com.example.mvvmshoppinglist.data.db

import androidx.room.*

@Dao
abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun upsert(entity: T)

    @Delete
    abstract fun delete(entity: T)
}