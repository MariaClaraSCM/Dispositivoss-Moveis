package br.edu.fatecpg.apploginfirebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val irCadastro = findViewById<TextView>(R.id.txv_irCadastro)

        irCadastro.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword("maria@gmail.com", "Abc123.123").addOnCompleteListener {
            task ->
                if (task.isSuccessful){
                    Log.i("FIREBASE", "LOGADO COM SUCESSO")
                }else{
                    Log.i("FIREBASE", "ERRO AO LOGAR ${task.exception}")
                }
        }

    }
}