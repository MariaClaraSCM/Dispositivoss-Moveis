package com.example.appdao.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appdao.R
import com.example.appdao.dao.ProdutoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNomeProduto = findViewById<EditText>(R.id.edt_nome_produto)
        val edtPrecoProduto = findViewById<EditText>(R.id.edt_preco_produto)
        val btnSalvarProduto = findViewById<Button>(R.id.btn_salvar_produto)
        val fabAvancar = findViewById<FloatingActionButton>(R.id.fab_avancar_tela_produto)

        btnSalvarProduto.setOnClickListener {
            val nomeProduto = edtNomeProduto.text.toString()
            val precoProduto = edtPrecoProduto.text.toString().toDouble()

            val retorno = ProdutoDao.salvar(nomeProduto, precoProduto)
            Log.i("ESTADO", retorno)
            Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
            edtPrecoProduto.text.clear()
            edtNomeProduto.text.clear()
        }

        fabAvancar.setOnClickListener {
            val intent = Intent(this, ProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}