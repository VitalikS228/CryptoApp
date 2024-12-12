package com.example.cryptoapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.Repository
import com.example.cryptoapp.domain.StockItem
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() : LiveData<List<StockItem>> {
        return repository.itemsLiveData
    }
}