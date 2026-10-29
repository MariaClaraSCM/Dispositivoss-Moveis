package br.edu.fatecpg.apploginfirebase

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore

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

        val db = Firebase.firestore
        val stamp = FieldValue.serverTimestamp()

        val edtcategoria = findViewById<EditText>(R.id.edt_cat)
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtPreco = findViewById<EditText>(R.id.edt_preco)
        val cadastrar = findViewById<Button>(R.id.btn_cadastrarProd)

//        val hashusuario = hashMapOf(
//            "nome" to "Bianca",
//            "cpf" to "222.222.222-98",
//            "dt_compra" to stamp
//        )

        cadastrar.setOnClickListener {
            val categoria = edtcategoria.text.toString()
            val nome = edtNome.text.toString()
            val preco = edtPreco.text.toString()

            val hashProduto = hashMapOf(
                "categoria" to categoria,
                "nome" to nome,
                "preco" to preco
            )

            db.collection("product_collection")
                .document("doc_product")
                .set(hashProduto)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                        edtcategoria.text.clear()
                        edtNome.text.clear()
                        edtPreco.text.clear()
                    }else{
                        Toast.makeText(this, "Falha ao cadastrar produto: ${task.exception}", Toast.LENGTH_SHORT).show()
                        edtcategoria.text.clear()
                        edtNome.text.clear()
                        edtPreco.text.clear()
                    }
                }
        }

//        db.collection("cliente_collection")
//            .document("doc_cliente")
//            .set(hashusuario)
//            .addOnCompleteListener { task ->
//                if(task.isSuccessful){
//                    Log.d("FIRESTORE", "SUCESSO!")
//                }else{
//                    Log.d("FIRESTORE", "FALHA ${task.exception}")
//                }
//            }
    }
}