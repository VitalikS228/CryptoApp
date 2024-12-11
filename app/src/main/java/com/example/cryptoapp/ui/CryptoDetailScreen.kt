package com.example.cryptoapp.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cryptoapp.data.local.CryptoEntity

@Composable
fun CryptoDetailScreen(
    crypto: CryptoEntity,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = crypto.name) }
            )
        },
        content = { padding ->
            // Display detailed information here
            Text(text = "Symbol: ${crypto.symbol}", modifier = Modifier.padding(padding))
            Text(text = "Price: $${crypto.price}", modifier = Modifier.padding(padding))
            // Add more details as needed
        }
    )
}
