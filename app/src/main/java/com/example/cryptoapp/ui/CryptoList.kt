package com.example.cryptoapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cryptoapp.data.local.CryptoEntity

@Composable
fun CryptoList(
    cryptos: List<CryptoEntity>,
    onItemClick: (CryptoEntity) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(cryptos) { crypto ->
            CryptoItem(crypto = crypto, onItemClick = onItemClick)
        }
    }
}
