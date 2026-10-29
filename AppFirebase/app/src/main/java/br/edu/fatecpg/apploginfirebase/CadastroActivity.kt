package br.edu.fatecpg.apploginfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth


class CadastroActivity : AppCompatActivity(R.layout.activity_cadastro) {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = FirebaseAuth.getInstance()

        val edtEmail = findViewById<EditText>(R.id.edt_cadastroEmail)
        val edtSenha = findViewById<EditText>(R.id.edt_cadastroSenha)
        val edtConfirmarSenha = findViewById<EditText>(R.id.edt_confirmarSenha)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val txvVoltarLogin = findViewById<TextView>(R.id.txv_voltarLogin)
        val fabVoltarLogin = findViewById<FloatingActionButton>(R.id.fab_voltarLogin)

        val email = edtEmail.text.toString()
        val senha = edtSenha.text.toString()
        val confirmarSenha = edtConfirmarSenha.text.toString()

        val intent = Intent(this, MainActivity::class.java)

        btnCadastrar.setOnClickListener {
            // 1. Pegamos os textos dos campos dentro do clique do botão
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString().trim()
            val confirmarSenha = edtConfirmarSenha.text.toString().trim()

            // 2. Usamos && (E) para garantir que NENHUM campo esteja vazio
            if (email.isNotEmpty() && senha.isNotEmpty() && confirmarSenha.isNotEmpty()) {

                // 3. Verificamos se as senhas batem
                if (senha == confirmarSenha) {

                    // 4. Chamamos o Firebase Auth
                    auth.createUserWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // SUCESSO: O usuário foi criado e logado de verdade no Firebase
                                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()

                                // Limpa os campos
                                edtEmail.text.clear()
                                edtSenha.text.clear()
                                edtConfirmarSenha.text.clear()

                                // Muda de tela SÓ DEPOIS que o cadastro deu certo
                                val intent = Intent(this, MainActivity::class.java) // Substitua MainActivity pela sua tela destino
                                startActivity(intent)
                                finish() // Opcional: fecha a tela de cadastro para o usuário não voltar nela com o botão "voltar"

                            } else {
                                // ERRO: Exemplo (senha menor que 6 caracteres, e-mail mal formatado, e-mail já em uso)
                                Toast.makeText(
                                    this,
                                    "Erro ao cadastrar: ${task.exception?.message}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }

                } else {
                    Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        fabVoltarLogin.setOnClickListener {
            startActivity(intent)
        }

        txvVoltarLogin.setOnClickListener {
            startActivity(intent)
        }

    }
}