package com.example.cryptoapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StockService {

    @GET("top/totalvolfull")
    suspend fun getAndroid(
        @Query("limit") courseData1: String = "30",
        @Query("tsym") courseData2: String = "USD"
    ): Response<ResponseHandler>
}
