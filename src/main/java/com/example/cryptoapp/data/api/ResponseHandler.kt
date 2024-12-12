package com.example.cryptoapp.data.api

import com.example.cryptoapp.domain.StockItem
import com.google.gson.annotations.SerializedName

data class ResponseHandler(
//    @SerializedName("Message") val message: String?,
//    @SerializedName("Type") val type: Int?,
    @SerializedName("Data") val data: List<AssetData>?
){
    fun toListStockItem(): List<StockItem>? = this.data?.map { it.toStockItem() }
}