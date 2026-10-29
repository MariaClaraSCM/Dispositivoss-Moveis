package com.example.appdao.dao

import com.example.appdao.model.Produto

//Controller do produto que será adicionado
class ProdutoDao {
    companion object{
        private var meuProduto = Produto()

        fun salvar(nome: String, preco: Double): String{
            meuProduto = Produto(nome, preco)
            return "Produto Salvo"
        }

        fun buscar():Produto{
            return meuProduto
        }
    }
}