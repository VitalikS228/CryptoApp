package com.example.cryptoapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoStockItem {

    @Query("SELECT * FROM stock_item_table ORDER BY lastUpdate ASC")
    fun itemsLiveData(): LiveData<List<StockEntity>>  // when function returns LiveData it has suspend-functionality under the hood.

    @Query("SELECT * FROM stock_item_table WHERE fromSymbol LIKE :fromSymbol LIMIT 1")
    suspend fun getItem(fromSymbol: String?): StockEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<StockEntity>)
}