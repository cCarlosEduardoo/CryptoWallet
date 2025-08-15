package com.example.walletcrypto.data.api
import com.example.walletcrypto.model.CryptoPriceResponse

import androidx.room.Query
import retrofit2.http.GET

interface CoinGeckoApiService {
    @GET("simple/price")
    suspend fun getPrice(
     @Query( "ids") ids: String,
     @Query("vs_currencies") vsCurrencies: String
    ): Map<String,CryptoPriceResponse>

}