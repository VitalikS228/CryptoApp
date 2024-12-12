package com.example.cryptoapp.data.db

import com.example.cryptoapp.domain.StockItem

fun StockItem.toStockEntity() : StockEntity {
    return StockEntity(
        fromSymbol = this.fromSymbol,
        toSymbol = this.toSymbol,
        lastMarket = this.lastMarket,
        price = this.price,
        lastUpdate = this.lastUpdate,
        supply = this.maxSupply,
        marketCap = this.totalMarketCap,
        imageUrl = this.iconUrl
    )
}

fun entitiesToItems(entities: List<StockEntity>) = entities.map { it.toStockItem() }