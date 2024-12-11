package com.example.cryptoapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.cryptoapp.data.local.CryptoEntity
import coil.compose.rememberAsyncImagePainter

@Composable
fun CryptoItem(
    crypto: CryptoEntity,
    onItemClick: (CryptoEntity) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(crypto) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(crypto.imageUrl),
                contentDescription = "${crypto.name} Logo",
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = crypto.name, style = MaterialTheme.typography.titleMedium)
                Text(text = crypto.symbol, style = MaterialTheme.typography.bodyMedium)
                Text(text = "$${crypto.price}", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
