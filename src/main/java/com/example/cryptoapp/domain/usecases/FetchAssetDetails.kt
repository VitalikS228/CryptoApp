package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.Repository
import com.example.cryptoapp.domain.StockItem
import javax.inject.Inject

class GetItemUseCase @Inject constructor(
    private val repository: Repository,
) {
    suspend operator fun invoke(fromSymbol: String?): StockItem {
        return repository.fetchRecord(fromSymbol)
    }
}