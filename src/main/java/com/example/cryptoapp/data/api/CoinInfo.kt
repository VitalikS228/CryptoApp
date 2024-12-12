package com.example.cryptoapp.data.api

import com.google.gson.annotations.SerializedName

data class CoinInfo(
    @SerializedName("Name") val name: String?,
    @SerializedName("FullName") val fullName: String?,
    @SerializedName("ImageUrl") val imageUrl: String?
)