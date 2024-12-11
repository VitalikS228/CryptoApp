package com.example.cryptoapp.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("data/top/totalvolfull")
    suspend fun getTopCryptocurrencies(
        @Query("limit") limit: Int,
        @Query("tsym") currency: String
    ): CryptoResponse
}