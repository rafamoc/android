package br.com.uniceub.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaLoginActivity : AppCompatActivity() {

    private lateinit var conexaoDB: ConexaoDB
    private lateinit var usuario: Usuario
    private lateinit var logger: Log

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        conexaoDB = ConexaoDB(this)
        usuario = Usuario(conexaoDB)
        logger  = Log(conexaoDB)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val etLogin = findViewById<EditText>(R.id.etLogin)
            val etSenha = findViewById<EditText>(R.id.etSenha)

            val login = etLogin.text.toString()
            val senha = etSenha.text.toString()

            validarUsuario(login, senha)
        }
    }

    fun validarUsuario(login: String, senha: String){

        // Verifica se o usuário é válido
        if (usuario.isValidUser(login, senha)) {
            // Gera um log de acesso bem sucedido
            logger.logLoginAttempt(login, true)


            // Abre a TelaPrincipalActivity se o login for bem-sucedido
            val intent = Intent(this, ListaUsuariosActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Gera um log de acesso mrafaeal sucedido
            logger.logLoginAttempt(login, false)

            // Exibe uma mensagem de erro se o login falhar
            Toast.makeText(this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show()
        }

    }
}
