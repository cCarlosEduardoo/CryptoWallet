package com.example.walletcrypto.data.api.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.walletcrypto.model.CryptoEntity

@Database(entities = [CryptoEntity::class], version = 1)
 abstract class AppDataBase : RoomDatabase() {
 abstract fun cryptoDao(): CryptoDao
}