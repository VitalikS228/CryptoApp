package com.example.cryptoapp

import com.example.cryptoapp.ui.theme.MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.cryptoapp.ui.theme.CryptoAppTheme
import com.example.cryptoapp.worker.RefreshWorker
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val refreshWorkRequest = PeriodicWorkRequestBuilder<RefreshWorker>(
            15, TimeUnit.MINUTES
        ).build()
        WorkManager.getInstance(this).enqueue(refreshWorkRequest)

        setContent {
            CryptoAppTheme {
                MainScreen()
            }
        }
    }
}
