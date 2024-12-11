package com.example.cryptoapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptoapp.data.local.CryptoEntity

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "cryptoList",
        modifier = modifier
    ) {
        composable("cryptoList") {
            val viewModel: CryptoViewModel = hiltViewModel()
            val cryptos by viewModel.cryptos.collectAsState()
            CryptoList(cryptos = cryptos, onItemClick = { crypto ->
                navController.navigate("cryptoDetail/${crypto.id}")
            })
        }
        composable("cryptoDetail/{cryptoId}") { backStackEntry ->
            val cryptoId = backStackEntry.arguments?.getString("cryptoId")
            // Fetch and display detailed info based on cryptoId
            // Implement CryptoDetailScreen
        }
    }
}
