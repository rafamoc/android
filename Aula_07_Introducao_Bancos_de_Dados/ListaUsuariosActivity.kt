package br.com.uniceub.android

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListaUsuariosActivity : AppCompatActivity() {

    private lateinit var conexaoDB: ConexaoDB
    private lateinit var usuario: Usuario
    private lateinit var layoutContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios)

        conexaoDB = ConexaoDB(this)
        usuario = Usuario(conexaoDB)
        layoutContainer = findViewById(R.id.LinearLayout2)

        // Chama o método para buscar os nomes dos usuários e exibi-los
        mostrarUsuarios()
    }

    private fun mostrarUsuarios() {
        val nomes = usuario.getAllUserNames()

        for (nome in nomes) {
            val textView = TextView(this)
            textView.text = nome
            textView.textSize = 18f
            textView.setPadding(16, 16, 16, 16)

            layoutContainer.addView(textView)
        }
    }
}
