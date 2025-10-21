package com.example.criptowallet

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.criptowallet.R
import com.example.criptowallet.controller.CryptoController
import com.example.criptowallet.WalletActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var btnWallet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listCryptos)
        btnWallet = findViewById(R.id.btnWallet)

        btnWallet.setOnClickListener {
            startActivity(Intent(this, WalletActivity::class.java))
        }

        lifecycleScope.launch {
            val cryptos = CryptoController.getTopCryptos()
            val adapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_list_item_1,
                cryptos.map { "${it.name} - $${it.price_usd}" }
            )
            listView.adapter = adapter

            listView.setOnItemClickListener { _, _, position, _ ->
                val crypto = cryptos[position]
                CryptoController.addToWallet(crypto, 1.0)
                Toast.makeText(this@MainActivity, "${crypto.name} adicionada à carteira", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
