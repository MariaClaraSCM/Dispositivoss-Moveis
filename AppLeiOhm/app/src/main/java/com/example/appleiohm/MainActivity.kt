package com.example.appleiohm

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

        val edtResistencia = findViewById<EditText>(R.id.edt_resistencia)
        val edtCorrente = findViewById<EditText>(R.id.edt_corrente)
        val edtTensao = findViewById<EditText>(R.id.edt_tensao)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        btnCalcular.setOnClickListener {

            val tensao = edtTensao.text.toString()
            val corrente = edtCorrente.text.toString()
            val resistencia = edtResistencia.text.toString()

            when {
                tensao.isEmpty() && corrente.isNotEmpty() && resistencia.isNotEmpty() -> {
                    val i = corrente.toDouble()
                    val r = resistencia.toDouble()

                    val v = i * r

                    txvResultado.setText("A tensão é %.2f V".format(v))
                }

                corrente.isEmpty() && tensao.isNotEmpty() && resistencia.isNotEmpty() -> {
                    val v = tensao.toDouble()
                    val r = resistencia.toDouble()

                    val i = v / r

                    txvResultado.setText("A corrente é %.2f A".format(i))
                }

                resistencia.isEmpty() && tensao.isNotEmpty() && corrente.isNotEmpty() -> {
                    val v = tensao.toDouble()
                    val i = corrente.toDouble()

                    val r = v / i

                    txvResultado.setText("A resistência é %.2f Ω".format(r))
                }

                else -> {
                    Toast.makeText(this, "Preencha apenas dois valores", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}