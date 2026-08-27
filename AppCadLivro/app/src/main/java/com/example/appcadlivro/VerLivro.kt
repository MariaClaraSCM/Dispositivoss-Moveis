package com.example.appcadlivro

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class VerLivro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_livro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvTituloPagLivros = findViewById<TextView>(R.id.txv_tituloLivroPagLivros)
        val txvNomeAutorPagLivros = findViewById<TextView>(R.id.txv_nomeAutorPagLivros)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)

        val tituloLivro = intent.getStringExtra("titulo_livro")
        txvTituloPagLivros.setText("Titulo do livro: $tituloLivro")
        val nomeAutor = intent.getStringExtra("nome_autor")
        txvNomeAutorPagLivros.setText("Nome do autor: $nomeAutor")

        fabVoltar.setOnClickListener {
            finish()
        }

    }
}