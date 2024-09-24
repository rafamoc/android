package br.com.avalanche.common

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.avalanche.R

class TelaConfiguracaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tela_configuracao)

        val btn_voltar = findViewById<Button>(R.id.tela_config_btn_voltar)

        btn_voltar.setOnClickListener{
            val intent = Intent(this, TelaPrincipalActivity::class.java)
            startActivity(intent)
        }
    }
}