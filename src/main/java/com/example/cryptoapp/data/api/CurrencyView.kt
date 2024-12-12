package com.example.cryptoapp.data.api

import com.google.gson.annotations.SerializedName

data class CurrencyView(
    @SerializedName("LASTMARKET") val lastMarket: String?
)