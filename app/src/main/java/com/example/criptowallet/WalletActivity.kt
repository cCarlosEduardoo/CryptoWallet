package com.example.criptowallet
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.criptowallet.R
import com.example.criptowallet.controller.CryptoController

class WalletActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        listView = findViewById(R.id.listWallet)
        btnBack = findViewById(R.id.btnBack)

        btnBack.setOnClickListener { finish() }

        updateList()
    }

    private fun updateList() {
        val wallet = CryptoController.getWallet()
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            wallet.map { "${it.name}: ${it.amount} unid." }
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val item = wallet[position]
            CryptoController.removeFromWallet(item.id)
            Toast.makeText(this, "${item.name} removida da carteira", Toast.LENGTH_SHORT).show()
            updateList()
        }
    }
}
