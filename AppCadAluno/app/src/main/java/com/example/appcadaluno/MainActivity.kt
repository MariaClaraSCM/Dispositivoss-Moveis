package com.example.appcadaluno

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

        val edtNomeAluno = findViewById<EditText>(R.id.edt_nomeAluno)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabAvancar = findViewById<FloatingActionButton>(R.id.fab_irAluno)
        var nomeAluno = ""

        btnCadastrar.setOnClickListener {
            nomeAluno = edtNomeAluno.text.toString()
            edtNomeAluno.text.clear()
            Toast.makeText(this, "Aluno cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }

        fabAvancar.setOnClickListener {
            val intent = Intent(this, MatriculaAluno::class.java)
            intent.putExtra("nome_aluno", nomeAluno)
            startActivity(intent)
        }
    }
}