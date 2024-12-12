package com.example.cryptoapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao {

    @Query("SELECT * FROM cryptocurrencies")
    fun getAllCryptocurrencies(): Flow<List<CryptoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCryptocurrencies(cryptos: List<CryptoEntity>): Unit
}
