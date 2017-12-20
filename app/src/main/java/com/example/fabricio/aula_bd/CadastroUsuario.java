package com.example.fabricio.aula_bd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuario extends AppCompatActivity {

    private final String TAG = "usuario";
    EditText edUsuario, edEmail, edSenha, edRSenha;
    Button btCadastro;

    // referência da classe usada para interagir com o BD
    BD_Usuario banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Carregando GUI do CadastroUsuario");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        Log.i(TAG, "Carregando componentes da GUI");
        edUsuario = (EditText) findViewById(R.id.edUsuario);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edSenha = (EditText) findViewById(R.id.edSenha);
        edRSenha = (EditText) findViewById(R.id.edRSenha);
        btCadastro = (Button) findViewById(R.id.btCadastrar);

        banco = new BD_Usuario(this);

        btCadastro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Log.i(TAG, "Chamando evento do btCadastro");

                Log.i(TAG, "Coletando dados informados pelo usuário");
                String usuario = edUsuario.getText().toString();
                String email = edEmail.getText().toString();
                String senha = edSenha.getText().toString();
                String rSenha = edRSenha.getText().toString();

                Log.i(TAG, "Confirmando senhas");
                if(senha.equals(rSenha)){
                    banco.salvarUsuario(usuario,email,senha,banco);
                    Toast.makeText(CadastroUsuario.this,"Cadastro realizado com sucesso!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CadastroUsuario.this,"As senhas não conferem",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
