package com.example.walletcrypto.data.api.Repository

import com.example.walletcrypto.data.api.RetrofitInstance
import com.example.walletcrypto.data.api.db.CryptoDao
import com.example.walletcrypto.model.CryptoEntity
import retrofit2.Retrofit

class CryptoRepository(private val dao: CryptoDao) {
    suspend fun getPrice(ids : String, vsCurrencies: String) =
        RetrofitInstance.api.getPrice(ids,vsCurrencies)

    suspend fun insertCrypto(crypto : CryptoEntity){
        dao.insert(crypto)
    }

    fun getAllCryptos() = dao.getAll()

}