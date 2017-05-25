package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;

public class MeusPets extends AppCompatActivity {

    private Toolbar toolbarMeusPets;
    private TextView textAdd;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_pets);

        toolbarMeusPets = (Toolbar) findViewById(R.id.toolbar_meusPets);
        toolbarMeusPets.setTitle("Meus Pets");
        setSupportActionBar(toolbarMeusPets);

        textAdd = (TextView) findViewById(R.id.textoAdd);
        textAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MeusPets.this, MeusPetsCad.class);
                startActivity(it);
            }
        });

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MeusPets.this, Modelo.class);
                startActivity(it);
            }
        });


    }
}
