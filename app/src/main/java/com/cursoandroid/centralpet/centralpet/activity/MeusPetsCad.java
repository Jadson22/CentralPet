package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cursoandroid.centralpet.centralpet.R;

public class MeusPetsCad extends AppCompatActivity {

    private Toolbar toolbarMeusPetsCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_pets_cad);

        toolbarMeusPetsCad = (Toolbar) findViewById(R.id.toolbar_meusPets_cad);
        toolbarMeusPetsCad.setTitle("Cadastro");
        setSupportActionBar(toolbarMeusPetsCad);
    }
}
