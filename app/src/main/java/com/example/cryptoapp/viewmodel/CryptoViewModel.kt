package com.example.cryptoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.local.CryptoRepository
import com.example.cryptoapp.data.local.CryptoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    private val _cryptos = MutableStateFlow<List<CryptoEntity>>(emptyList())
    val cryptos: StateFlow<List<CryptoEntity>> = _cryptos.asStateFlow()

    init {
        viewModelScope.launch {
            repository.allCryptos.collect { cryptosList ->
                _cryptos.value = cryptosList
            }
        }
    }
}
