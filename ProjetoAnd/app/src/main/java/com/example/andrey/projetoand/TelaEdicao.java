package com.example.andrey.projetoand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.andrey.projetoand.Controller.Controller;

public class TelaEdicao extends AppCompatActivity {

    private EditText etnome;
    private String nomeEdicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_edicao);

        etnome = (EditText) findViewById(R.id.et_nome);

    }


    public void voltar(View view) {
        nomeEdicao = etnome.getText().toString();
        Controller.getInstance().setValue(nomeEdicao);
        Intent intent = new Intent(TelaEdicao.this, TelaMenu.class);
        startActivity(intent);
        finish();
    }

}