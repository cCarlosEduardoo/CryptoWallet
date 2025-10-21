package com.example.criptowallet.controller

import com.example.criptowallet.model.Crypto
import com.example.criptowallet.model.WalletItem
import com.example.criptowallet.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object CryptoController {
    private val wallet = mutableListOf<WalletItem>()

    // Busca os preços da CoinGecko
    suspend fun getTopCryptos(): List<Crypto> = withContext(Dispatchers.IO) {
        val response = RetrofitClient.api.getTopCryptos()
        response.map { it.toModel() }
    }

    // Retorna itens da carteira
    fun getWallet(): List<WalletItem> = wallet

    // Adiciona à carteira
    fun addToWallet(crypto: Crypto, amount: Double) {
        val existing = wallet.find { it.id == crypto.id }
        if (existing != null) {
            existing.amount += amount
        } else {
            wallet.add(WalletItem(crypto.id, crypto.symbol, crypto.name, amount))
        }
    }

    // Remove da carteira
    fun removeFromWallet(id: String) {
        wallet.removeAll { it.id == id }
    }
}
