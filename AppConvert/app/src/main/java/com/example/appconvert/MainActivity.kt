package com.example.appconvert

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

        val edtTemperatura = findViewById<EditText>(R.id.edt_temperatura)
        val btnCelcius = findViewById<Button>(R.id.btn_convertCelcius)
        val btnFahrenheit = findViewById<Button>(R.id.btn_convertFahrenheit)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        fun temperatura(): Double {
            return edtTemperatura.text.toString().toDouble()
        }

        fun converterParaCelsius(fahrenheit: Double): Double {
            return (fahrenheit - 32) * 5 / 9
        }

        fun converterParaFahrenheit(celsius: Double): Double {
            return (celsius * 9 / 5) + 32
        }

        btnCelcius.setOnClickListener {
            val valor = temperatura()
            val resultado = converterParaCelsius(valor)
            txvResultado.text = "Celsius: ${String.format("%.4f", resultado)}"
            Toast.makeText(this, "Conversão para Celsius feita com sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnFahrenheit.setOnClickListener {
            val valor = temperatura()
            val resultado = converterParaFahrenheit(valor)
            txvResultado.text = "Fahrenheit: ${String.format("%.4f", resultado)}"
            Toast.makeText(this, "Conversão para Fahrenheit feita com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }
}