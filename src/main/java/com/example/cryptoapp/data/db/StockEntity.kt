package com.example.cryptoapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.domain.StockItem
import com.google.gson.annotations.SerializedName


@Entity(tableName = "stock_item_table")
data class StockEntity(

    @SerializedName("FROMSYMBOL")
    val fromSymbol: String?,

    @SerializedName("TOSYMBOL")
    val toSymbol: String?,

    @SerializedName("LASTMARKET")
    val lastMarket: String?,

    @SerializedName("PRICE")
    val price: String?,

    @PrimaryKey(autoGenerate = true)
    @SerializedName("LASTUPDATE")
    val lastUpdate: Long?,

    @SerializedName("HIGHDAY")
    val supply: String?,

    @SerializedName("LOWDAY")
    val marketCap: String?,

    @SerializedName("IMAGEURL")
    val imageUrl: String?
) {
    fun toStockItem(): StockItem {
        return StockItem(
            fromSymbol = this.fromSymbol,
            toSymbol = this.toSymbol,
            lastMarket = this.lastMarket,
            price = this.price,
            lastUpdate = this.lastUpdate,
            maxSupply = this.supply,
            totalMarketCap = this.marketCap,
            iconUrl = "https://www.cryptocompare.com${this.imageUrl ?: ""}"
        )
    }
}