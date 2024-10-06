package com.example.databaseroom2.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: Item)

    @Query("DELETE from items where name =:iname")
    suspend fun deleteItemByName(iname: String)

    @Query("SELECT * from items")
    fun getAllItems(): LiveData<List<Item>>


}