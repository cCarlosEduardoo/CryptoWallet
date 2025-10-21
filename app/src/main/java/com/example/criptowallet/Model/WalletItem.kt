package com.example.criptowallet.model

data class WalletItem(
    val id: String,
    val symbol: String,
    val name: String,
    var amount: Double
)
