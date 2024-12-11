package com.example.cryptoapp.api

import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("Data")
    val data: List<CryptoData>
)

data class CryptoData(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfo,
    @SerializedName("DISPLAY")
    val display: Map<String, CurrencyData> // Динамічна структура для валют
)

data class CoinInfo(
    @SerializedName("Id")
    val id: String,
    @SerializedName("FullName")
    val fullName: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("ImageUrl")
    val imageUrl: String
)

data class CurrencyData(
    @SerializedName("PRICE")
    val price: String
)
