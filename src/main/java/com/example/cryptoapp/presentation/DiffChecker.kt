package com.example.cryptoapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.domain.StockItem

class DiffChecker: DiffUtil.ItemCallback<StockItem>() {
    override fun areItemsTheSame(oldItem: StockItem, newItem: StockItem) =
        oldItem.fromSymbol == newItem.fromSymbol

    override fun areContentsTheSame(oldItem: StockItem, newItem: StockItem) =
        oldItem == newItem
}