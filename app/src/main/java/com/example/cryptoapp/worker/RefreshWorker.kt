package com.example.cryptoapp.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.cryptoapp.api.RetrofitInstance
import com.example.cryptoapp.data.local.CryptoDatabase
import com.example.cryptoapp.repository.CryptoRepository

class RefreshWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val dao = CryptoDatabase.getDatabase(applicationContext).cryptoDao()
        val api = RetrofitInstance.api
        val repository = CryptoRepository(dao, api)

        return try {
            repository.refreshCryptos()
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }
    }
}
