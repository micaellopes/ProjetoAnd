package com.example.andrey.projetoand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TelaLogin extends AppCompatActivity {


    String leva;
    EditText editLogin1, editSenha1;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        Button btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Login1 = (EditText) findViewById(R.id.editLogin1);
                EditText Senha1 = (EditText) findViewById(R.id.editSenha1);
                String login = Login1.getText().toString();
                String senha = Senha1.getText().toString();
                if (login.equals("Micael") && senha.equals("kermic123")) {
                    alert("Login Realizado com sucesso");
                    Intent intent = new Intent(getApplicationContext(), TelaMenu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    alert("Login ou senha incorretos");
                }

            }
        });

    }
        private void alert(String s){
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();

        };

    }
