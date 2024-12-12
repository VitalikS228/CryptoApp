package com.example.cryptoapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.StockItem
import com.example.cryptoapp.domain.usecases.GetItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockItemViewModel @Inject constructor(
    private val getItemUseCase: GetItemUseCase,
) : ViewModel() {

    private val _itemLiveData = MutableLiveData<StockItem>()
    val itemLiveData: LiveData<StockItem>
        get() = _itemLiveData

    fun getItem(fromSymbol: String) {
        viewModelScope.launch {
            val stockItem = getItemUseCase(fromSymbol)
            _itemLiveData.value = stockItem
        }
    }
}
