package com.example.cryptoapp.repository

import com.example.cryptoapp.api.ApiService
import com.example.cryptoapp.data.local.CryptoDao
import com.example.cryptoapp.data.local.CryptoEntity
import com.example.cryptoapp.api.CryptoResponse
import kotlinx.coroutines.flow.Flow

class CryptoRepository(
    private val dao: CryptoDao,
    private val api: ApiService
) {
    val allCryptos: Flow<List<CryptoEntity>> = dao.getAllCryptocurrencies()

    suspend fun refreshCryptos() {
        val response = api.getTopCryptocurrencies(30, "USD")
        val entities = response.data.map {
            val currencyData = it.display["USD"]
            CryptoEntity(
                id = it.coinInfo.id,
                name = it.coinInfo.fullName,
                symbol = it.coinInfo.name,
                price = currencyData?.price?.toDouble() ?: 0.0,
                imageUrl = "https://www.cryptocompare.com${it.coinInfo.imageUrl}"
            )
        }
        dao.insertCryptocurrencies(entities)
    }

}
