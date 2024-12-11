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
    val display: DisplayData
)

data class CoinInfo(
    @SerializedName("Id")
    val id: String,

    @SerializedName("Name")
    val name: String,

    @SerializedName("FullName")
    val fullName: String,

    @SerializedName("ImageUrl")
    val imageUrl: String
)

data class DisplayData(
    @SerializedName("USD")
    val usd: USDData
)

data class USDData(
    @SerializedName("PRICE")
    val price: String
)