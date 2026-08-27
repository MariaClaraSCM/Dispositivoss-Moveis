package com.example.apptelas

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

        val edtNomeUser = findViewById<EditText>(R.id.edt_nome_usuario)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)
        var nomeUser = ""

        btnSalvar.setOnClickListener {
            nomeUser = edtNomeUser.text.toString()
            edtNomeUser.text.clear()
            Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show()

        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            intent.putExtra("nome_user", nomeUser)
            startActivity(intent)
        }
    }
}