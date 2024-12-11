package com.example.cryptoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.api.RetrofitInstance
import com.example.cryptoapp.data.local.CryptoDatabase
import com.example.cryptoapp.repository.CryptoRepository
import kotlinx.coroutines.launch

class CryptoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CryptoRepository

    val allCryptos = CryptoDatabase.getDatabase(application).cryptoDao().getAllCryptocurrencies()

    init {
        val dao = CryptoDatabase.getDatabase(application).cryptoDao()
        val api = RetrofitInstance.api
        repository = CryptoRepository(dao, api)
    }

    fun refreshCryptos() {
        viewModelScope.launch {
            repository.refreshCryptos()
        }
    }
}
