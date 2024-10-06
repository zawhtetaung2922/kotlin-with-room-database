package com.example.databaseroom2.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ItemViewModel(application: Application): AndroidViewModel(application) {

    private val repository: ItemRepository

    init {
        val itemDao=InventoryDatabase.getDatabase(application).itemDao()
        repository= ItemRepository(itemDao)
    }
    fun  insertItem(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertItem(item)
        }
    }

    fun deleteItem(iname:String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItemByName(iname)
        }
    }

    fun showAllItems(): LiveData<List<Item>> {
        return repository.getAllItems()  // Directly return LiveData from repository
    }



}