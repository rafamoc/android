package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    public Button tela_sobre_btn_voltar;

    //
    public Button btn_pesquisa;
    public Button tela_pesquisa_btn_voltar;

    // Views da Tela de Configurações
    public Button tela_config_btn_voltar;

    TextView[] textViews = new TextView[10];

    private float startX;

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

        btn_pesquisa = findViewById(R.id.btn_pesquisa);

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

        btn_pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPesquisa();
            }
        });
    }

    private void CarregarTelaPesquisa(){

        setContentView(R.layout.tela_pesquisa);

        EditText editTextFilter = findViewById(R.id.txt_pesquisa);

        textViews[0] = findViewById(R.id.textView0);
        textViews[1] = findViewById(R.id.textView1);
        textViews[2] = findViewById(R.id.textView2);
        textViews[3] = findViewById(R.id.textView3);
        textViews[4] = findViewById(R.id.textView4);
        textViews[5] = findViewById(R.id.textView5);
        textViews[6] = findViewById(R.id.textView6);
        textViews[7] = findViewById(R.id.textView7);
        textViews[8] = findViewById(R.id.textView8);
        textViews[9] = findViewById(R.id.textView9);

        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // Método chamado enquanto o texto está sendo digitado
                String filterText = charSequence.toString().toLowerCase();

                // Filtrar os TextViews com base no texto digitado
                for (TextView textView : textViews) {
                    String textViewContent = textView.getText().toString().toLowerCase();

                    // Verifica se o conteúdo do TextView contém o texto digitado
                    if (textViewContent.contains(filterText)) {
                        textView.setVisibility(TextView.VISIBLE);  // Mostrar o TextView se corresponder ao filtro
                    } else {
                        textView.setVisibility(TextView.GONE);     // Ocultar o TextView se não corresponder
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        tela_pesquisa_btn_voltar = findViewById(R.id.tela_pesquisa_btn_voltar);
        tela_pesquisa_btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });

        LinearLayout mainLayout = findViewById(R.id.layout_tela_pesquisa);

        // Adiciona o OnTouchListener ao layout
        mainLayout.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Captura a posição inicial do toque
                        startX = motionEvent.getX();
                        return true;

                    case MotionEvent.ACTION_UP:
                        // Captura a posição final do toque
                        float endX = motionEvent.getX();
                        float deltaX = endX - startX;

                        // Verifica se o movimento foi para a direita
                        if (deltaX > 100) { // Ajuste o valor 100 conforme necessário
                            CarregarTelaPrincipal(); // Função para carregar outro layout
                        }
                        return true;

                    default:
                        return false;
                }
            }
        });




    }

    private void CarregarTelaSobreOApp(){

        setContentView(R.layout.sobre_o_app);

        tela_sobre_btn_voltar = findViewById(R.id.tela_sobre_btn_voltar);
        tela_sobre_btn_voltar.setOnClickListener(new View.OnClickListener() {
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

        return true;

        /*EditText txtLogin  = findViewById(R.id.txt_login);
        EditText txtPass   = findViewById(R.id.txt_password);

        String login = String.valueOf(txtLogin.getText());
        String senha = String.valueOf(txtPass.getText());

        if(login == "rafael.nogueira" && senha == "123456")
            return true;

        return false;*/

    }
}
