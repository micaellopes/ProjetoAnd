package com.example.andrey.projetoand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaConfig extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_config);

    }

    public void tela2(View view) {
        Intent intent = new Intent(TelaConfig.this, TelaMenu.class);
        startActivity(intent);
        finish();
    }

}
