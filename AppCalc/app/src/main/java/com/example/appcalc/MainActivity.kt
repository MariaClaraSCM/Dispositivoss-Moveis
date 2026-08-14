package com.example.appcalc

import android.content.ComponentName
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvResultado = findViewById<TextView>(R.id.txv_resultado)
        val edtValor1 = findViewById<EditText>(R.id.edt_valor1)
        val edtValor2 = findViewById<EditText>(R.id.edt_valor2)
        val btnAdicao = findViewById<Button>(R.id.btn_adição)
        val btnSubtracao = findViewById<Button>(R.id.btn_subtração)
        val btnDivisao = findViewById<Button>(R.id.btn_divisão)
        val btnMultiplicacao = findViewById<Button>(R.id.btn_multiplicação)

        fun pegarValores(): Pair<Double, Double>{
            val valor1 = edtValor1.text.toString().toDouble()
            val valor2 = edtValor2.text.toString().toDouble()

            return Pair(valor1, valor2)
        }

        btnAdicao.setOnClickListener {
            val (valor1, valor2) = pegarValores()
            val soma = valor1 + valor2
            txvResultado.setText("A soma é: $soma")
            edtValor1.text.clear()
            edtValor2.text.clear()
            Toast.makeText(this, "Adição realizada com sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnSubtracao.setOnClickListener {
            val (valor1, valor2) = pegarValores()
            val subtracao = valor1 - valor2
            txvResultado.setText("A subtração é $subtracao")
            edtValor1.text.clear()
            edtValor2.text.clear()
            Toast.makeText(this, "Subtração realizada com sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnDivisao.setOnClickListener {
            val (valor1, valor2) = pegarValores()
            val divisao = valor1/valor2
            txvResultado.setText("A divisão é $divisao")
            edtValor1.text.clear()
            edtValor2.text.clear()
            Toast.makeText(this, "Divisão realizada com sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnMultiplicacao.setOnClickListener {
            val (valor1, valor2) = pegarValores()
            val multiplicacao = valor1*valor2
            txvResultado.setText("A multiplicação é $multiplicacao")
            edtValor1.text.clear()
            edtValor2.text.clear()
            Toast.makeText(this, "Multiplicação realizada com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }
}