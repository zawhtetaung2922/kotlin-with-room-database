package com.example.databaseroom2.data

import androidx.room.*
@Entity(tableName = "Items")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val name: String,
    val price: Double,
    val quantity: Int

)