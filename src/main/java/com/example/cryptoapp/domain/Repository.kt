package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

interface Repository {
    val itemsLiveData: LiveData<List<StockItem>>
    suspend fun fetchRecord(fromSymbol: String?): StockItem
    suspend fun initializeRecords()
}