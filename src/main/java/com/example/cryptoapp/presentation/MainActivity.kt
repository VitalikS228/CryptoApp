package com.example.cryptoapp.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.domain.StockItem
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<StockViewModel>()
    private val listBinder = ListBinder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.loadData()

        viewModel.itemsLiveData.observe(this) {
            Log.d("XXXX", "getItemUseCase: $it")

            listBinder.submitList(it)
        }

        binding.stockItems.layoutManager = LinearLayoutManager(this)
        binding.stockItems.adapter = listBinder
        listBinder.itemsInteractionListener = object : ListBinder.ItemsInteractionListener {
            override fun onClick(stockItem: StockItem) {
                stockItem.fromSymbol?.let {
                    startStockItemViewActivity(stockItem)
                } ?: Log.e("MainActivity", "fromSymbol is null for the clicked item")
            }

        }
    }



    private fun startStockItemViewActivity(stockItem: StockItem) {
        Log.d("MainActivity", "Starting StockItemViewActivity with fromSymbol: ${stockItem.fromSymbol}")
        val intent = Intent(this, StockItemViewActivity::class.java).apply {
            putExtra(EXTRA_ITEM_FSYM, stockItem.fromSymbol)
        }
        startActivity(intent)
    }


}
