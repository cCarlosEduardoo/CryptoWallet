package com.example.criptowallet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.criptowallet.model.Crypto

class CryptoAdapter(context: Context, private val cryptos: List<Crypto>) :
    ArrayAdapter<Crypto>(context, 0, cryptos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_crypto, parent, false)

        val crypto = cryptos[position]

        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtPrice = view.findViewById<TextView>(R.id.txtPrice)

        txtName.text = "${crypto.name} (${crypto.symbol.uppercase()})"
        txtPrice.text = "$${String.format("%.2f", crypto.price_usd)}"


        return view
    }
}
