package com.example.cryptoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cryptocurrencies")
data class CryptoEntity(
    @PrimaryKey val id: String,
    val name: String,
    val symbol: String,
    val price: Double,
    val imageUrl: String
)
