package com.example.appdaoimc.dao

import com.example.appdaoimc.model.IMC

class ImcDao {
    companion object{
        private var meuImc = IMC()

        fun calcular(altura: Double, peso: Double): String{
            meuImc = IMC(altura, peso)
            return "IMC calculado"
        }

        fun buscar(): IMC{
            return meuImc
        }
    }
}