package br.com.avalanche.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.avalanche.R;

public class TelaPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tela_principal);

        // Referências para os botões
        Button btn_sobre = findViewById(R.id.btn_sobre);
        Button btn_config = findViewById(R.id.btn_config);
        Button btn_sair = findViewById(R.id.btn_sair);

        btn_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalActivity.this, SobreOAppActivity.class);
                startActivity(intent);
            }
        });

        btn_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalActivity.this, TelaConfiguracaoActivity.class);
                startActivity(intent);
            }
        });

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalActivity.this, TelaLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}