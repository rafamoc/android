package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Views da Tela de Login
    public Button btn_login;

    // Views da Tela Principal
    public Button btn_sobre;
    public Button btn_config;
    public Button btn_sair;

    // Views da Tela Sobre_o_App
    public Button btn_voltar;

    // Views da Tela de Configurações
    public Button tela_config_btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        CarregarTelaLogin();

    }

    private void CarregarTelaLogin(){

        // Carrega a Tela Inicial do Nosso aplicativo como sendo a tela de login
        setContentView(R.layout.tela_login);

        // Configura os componentes de interface da tela de login
        btn_login = findViewById(R.id.button);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidaUsuario() == true)
                    CarregarTelaPrincipal();
            }
        });

    }

    private void CarregarTelaPrincipal(){
        // Trocar o layout para Tela 2
        setContentView(R.layout.tela_principal);

        // Configura os componentes de interface da tela de login
        btn_sobre = findViewById(R.id.btn_sobre);
        btn_config = findViewById(R.id.btn_config);
        btn_sair = findViewById(R.id.btn_sair);

        btn_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaSobreOApp();
            }
        });

        btn_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaConfiguracao();
            }
        });

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaLogin();
            }
        });
    }

    private void CarregarTelaSobreOApp(){

        setContentView(R.layout.sobre_o_app);

        btn_voltar = findViewById(R.id.tela_sobre_btn_voltar);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });


    }

    private void CarregarTelaConfiguracao(){

        setContentView(R.layout.tela_configuracao);

        tela_config_btn_voltar = findViewById(R.id.tela_config_btn_voltar);
        tela_config_btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });

    }

    private boolean ValidaUsuario(){

        EditText txtLogin  = findViewById(R.id.txt_login);
        EditText txtPass   = findViewById(R.id.txt_password);

        String login = String.valueOf(txtLogin.getText());
        String senha = String.valueOf(txtPass.getText());

        if(login == "rafael.nogueira" && senha == "123456")
            return true;

        return false;

    }
}
