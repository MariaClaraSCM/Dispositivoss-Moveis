package com.example.appdao.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appdao.R
import com.example.appdao.dao.ProdutoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProdutoActivity : AppCompatActivity(R.layout.activity_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvNomeProduto = findViewById<TextView>(R.id.txv_nome_produto)
        val txvPrecoProduto = findViewById<TextView>(R.id.txv_preco_produto)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)

        val produto = ProdutoDao.buscar()

        txvNomeProduto.setText("Nome do produto: ${produto.nome}")
        txvPrecoProduto.setText("Preço produto: ${produto.preco}")

        fabVoltar.setOnClickListener {
            finish()
        }

    }
}