package com.example.cryptoapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cryptoapp.data.api.RetrofitObject
import com.example.cryptoapp.domain.StockItem
import com.example.cryptoapp.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {

    private val recordSet = mutableSetOf<StockItem>()
    private val _recordStream = MutableLiveData<List<StockItem>>()

    override val itemsLiveData: LiveData<List<StockItem>>
        get() = _recordStream

    override suspend fun fetchRecord(sourceKey: String?): StockItem {
        Log.d("DataHandlerImpl", "Looking for item with fromSymbol: $sourceKey")
        recordSet.forEach { Log.d("RepositoryImpl", "Available item: ${it.fromSymbol}") }
        return recordSet.find {
            it.fromSymbol == sourceKey
        } ?: throw IllegalStateException("Item $sourceKey isn't found")
    }

    override suspend fun initializeRecords() {
        try {
            val response = withContext(Dispatchers.IO) {
                RetrofitObject.stockService.getAndroid()
            }

            if (response.isSuccessful) {
                val stockItems = response.body()?.data?.map { it.toStockItem() } ?: emptyList()
                Log.d("XXXX", "Loaded ${stockItems.size} stocks $stockItems")
                recordSet.clear()
                recordSet.addAll(stockItems)
                withContext(Dispatchers.Main) {
                    _recordStream.value = stockItems
                }
            } else {
                Log.e("DATA_SYNC", "Error: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("DATA_SYNC", "Failed to load data: ${e.localizedMessage}")
        }
    }

    init {
        refreshStream()
    }

    private fun refreshStream() {
        _recordStream.value = recordSet.toList()
    }
}
