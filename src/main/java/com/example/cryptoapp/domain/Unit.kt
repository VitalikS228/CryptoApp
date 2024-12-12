package com.example.cryptoapp.domain

data class StockItem (
    val fromSymbol: String?,
    val toSymbol: String?,
    val lastMarket: String?,
    val price: String?,
    val lastUpdate: Long?,
    val maxSupply: String?,
    val totalMarketCap: String?,
    val iconUrl: String?)
