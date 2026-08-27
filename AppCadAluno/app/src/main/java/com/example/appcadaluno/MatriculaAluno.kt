package com.example.appcadaluno

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MatriculaAluno : AppCompatActivity(R.layout.activity_matricula_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvNomeAlunoCadastrado = findViewById<TextView>(R.id.txv_nomeAlunoCadastrado)
        val txvMatriculaAluno = findViewById<TextView>(R.id.txv_matriculaAluno)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)

        val nomeAluno = intent.getStringExtra("nome_aluno")
        txvNomeAlunoCadastrado.setText("Nome do aluno: $nomeAluno")

        if(txvMatriculaAluno.text.toString().isEmpty()){
            val numeroMatricula = (1000..999999).random()
            numeroMatricula.toString()
            txvMatriculaAluno.setText("Numero de matricula: $numeroMatricula")
        }else{
            Toast.makeText(this,"Numero de matricula já foi gerado!", Toast.LENGTH_SHORT).show()
        }
    }
}