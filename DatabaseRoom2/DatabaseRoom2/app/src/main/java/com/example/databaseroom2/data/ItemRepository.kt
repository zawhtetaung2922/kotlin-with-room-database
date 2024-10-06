package com.example.databaseroom2.data

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao:ItemDao) {
    suspend fun insertItem(item: Item){
        itemDao.insertItem(item)
    }

    suspend fun deleteItemByName(iname: String){
        itemDao.deleteItemByName(iname)
    }

    fun getAllItems(): LiveData<List<Item>> {
        return itemDao.getAllItems()
    }


}