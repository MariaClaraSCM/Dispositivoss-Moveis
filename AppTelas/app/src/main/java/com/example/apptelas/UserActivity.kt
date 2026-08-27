package com.example.apptelas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvSaudacao = findViewById<TextView>(R.id.txv_saudacao)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)

        val nomeUser = intent.getStringExtra("nome_user")
        txvSaudacao.setText("Bem-vindo(a) usuario $nomeUser")

        fabVolta.setOnClickListener {
            finish()
        }
    }
}