package com.example.criptowallet.network

import com.example.criptowallet.model.Crypto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinGeckoApi {

    @GET("coins/markets")
    suspend fun getTopCryptos(
        @Query("vs_currency") currency: String = "usd",
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = false
    ): List<CryptoResponse>
}

data class CryptoResponse(
    val id: String,
    val symbol: String,
    val name: String,
    val current_price: Double
) {
    fun toModel(): Crypto {
        return Crypto(id, symbol, name, current_price)
    }
}
