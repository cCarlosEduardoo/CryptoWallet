package com.example.walletcrypto.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walletcrypto.data.api.Repository.CryptoRepository
import com.example.walletcrypto.model.CryptoEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class CryptoViewModel(private val repository : CryptoRepository) : ViewModel() {

    private val _prices = MutableStateFlow<Map<String,Any>>(emptyMap())
    val prices: StateFlow<Map<String,Any>> = _prices

    fun fetchPrices(ids: String, vsCurrencies: String) {
        viewModelScope.launch {
            val response = repository.getPrice(ids, vsCurrencies)
            _prices.value = response
        }
    }

    fun addCrypto(crypto: CryptoEntity) {
        viewModelScope.launch {
            repository.insertCrypto(crypto)
        }
    }

    fun getWallet() = repository.getAllCryptos()
}
