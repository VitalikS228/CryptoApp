package com.example.cryptoapp.data.api

import com.google.gson.annotations.SerializedName

data class CurrencyData(
    @SerializedName("FROMSYMBOL") val fromSymbol: String?,
    @SerializedName("TOSYMBOL") val toSymbol: String?,
    @SerializedName("PRICE") val price: Double?,
    @SerializedName("LASTUPDATE") val lastUpdate: Long?,
    @SerializedName("HIGHDAY") val highDay: Double?,
    @SerializedName("LOWDAY") val lowDay: Double?
)