package com.example.cryptoapp.data.api

import com.example.cryptoapp.domain.StockItem
import com.google.gson.annotations.SerializedName

data class AssetData(
    @SerializedName("CoinInfo") val coinInfo: CoinInfo?,
    @SerializedName("RAW") val raw: RawData?,
    @SerializedName("DISPLAY") val display: DisplayData?
) {
    fun toStockItem(): StockItem {
        return StockItem(
            fromSymbol = this.raw?.usd?.fromSymbol,
            toSymbol = this.raw?.usd?.toSymbol,
            lastMarket = this.display?.currencyView?.lastMarket,
            price = this.raw?.usd?.price.toString(),
            lastUpdate = this.raw?.usd?.lastUpdate,
            maxSupply = this.raw?.usd?.highDay.toString(),
            totalMarketCap = this.raw?.usd?.lowDay.toString(),
            iconUrl = "https://www.cryptocompare.com${this.coinInfo?.imageUrl ?: ""}"
        )
    }
}