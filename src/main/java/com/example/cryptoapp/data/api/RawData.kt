package com.example.cryptoapp.data.api

import com.google.gson.annotations.SerializedName

data class RawData(
    @SerializedName("USD") val usd: CurrencyData?
)