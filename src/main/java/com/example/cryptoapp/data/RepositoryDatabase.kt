package com.example.cryptoapp.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.cryptoapp.data.db.StockDatabase
import com.example.cryptoapp.data.db.StockEntity
import com.example.cryptoapp.data.db.entitiesToItems
import com.example.cryptoapp.domain.Repository
import com.example.cryptoapp.domain.StockItem
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.cryptoapp.data.api.RetrofitObject
import com.example.cryptoapp.data.db.toStockEntity
import javax.inject.Inject

class RepositoryDatabase @Inject constructor(@ApplicationContext context: Context) : Repository {

    private val dao = StockDatabase.getDatabase(context).wordDao()

    override val itemsLiveData: LiveData<List<StockItem>>
        get() {
            val entityLiveData: LiveData<List<StockEntity>> = dao.itemsLiveData()

            val mediatorLiveData = MediatorLiveData<List<StockItem>>()

            mediatorLiveData.addSource(entityLiveData) { entities ->
                mediatorLiveData.value = entitiesToItems(entities)
            }

            return mediatorLiveData
        }


    override suspend fun fetchRecord(fromSymbol: String?): StockItem {
        return dao.getItem(fromSymbol).toStockItem()
    }


    override suspend fun initializeRecords() {
        try {
            //val response = RetrofitObject.stockService.getAndroid()
            val response = withContext(Dispatchers.IO) {
                RetrofitObject.stockService.getAndroid()
            }

            if (response.isSuccessful) {
                val dataRecords = response.body()?.data?.map { it.toStockItem() } ?: emptyList()

                val dbRecords = dataRecords.map { it.toStockEntity()}
                Log.d("XXXX", "Loaded ${dbRecords.size} stocks $dbRecords")

                withContext(Dispatchers.IO) {
                    dao.insert(dbRecords)
                }
            } else {
                Log.e("XXXX", "Error: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("XXXX", "Failed to load data: ${e.localizedMessage}")
        }
    }
}