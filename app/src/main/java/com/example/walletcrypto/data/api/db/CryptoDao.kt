package com.example.walletcrypto.data.api.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.walletcrypto.model.CryptoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao {
    @Insert
    suspend fun insert(crypto: CryptoEntity)

    @Query("SELECT * FROM wallet")
    fun getAll(): Flow<List<CryptoEntity>>
}