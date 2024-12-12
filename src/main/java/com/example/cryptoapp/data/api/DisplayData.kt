package com.example.cryptoapp.data.api

import com.google.gson.annotations.SerializedName

data class DisplayData(
    @SerializedName("USD") val currencyView: CurrencyView?
)