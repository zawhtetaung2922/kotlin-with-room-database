package com.example.databaseroom2.data

import android.content.Context
import androidx.room.*
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase: RoomDatabase() {

    abstract fun itemDao():ItemDao
    companion object{
        @Volatile
        private var INSTANCE:InventoryDatabase?=null
        fun getDatabase(context: Context):InventoryDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance=Room.databaseBuilder(
                    context.applicationContext,
                    InventoryDatabase::class.java,
                    name="inventory_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }

}