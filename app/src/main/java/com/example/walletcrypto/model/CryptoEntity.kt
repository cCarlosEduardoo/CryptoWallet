package com.example.walletcrypto.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallet")
data class CryptoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val amount: Double
)
