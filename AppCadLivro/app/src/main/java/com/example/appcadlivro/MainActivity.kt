package com.example.appcadlivro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val edtTituloLivro = findViewById<EditText>(R.id.edt_tituloLivro)
        val edtNomeAutor = findViewById<EditText>(R.id.edt_nomeAutor)
        val btnSalvarLivro = findViewById<Button>(R.id.btn_salvarLivro)
        val fabAvancar = findViewById<FloatingActionButton>(R.id.fab_avancar)
        var tituloLivro = ""
        var nomeAutor = ""

        btnSalvarLivro.setOnClickListener {
            tituloLivro = edtTituloLivro.text.toString()
            nomeAutor = edtNomeAutor.text.toString()
            edtTituloLivro.text.clear()
            edtNomeAutor.text.clear()
            Toast.makeText(this, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }

        fabAvancar.setOnClickListener {
            val intent = Intent(this, VerLivro::class.java)
            intent.putExtra("titulo_livro", tituloLivro)
            intent.putExtra("nome_autor", nomeAutor)
            startActivity(intent)
        }
    }
}