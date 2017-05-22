package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cursoandroid.centralpet.centralpet.R;

public class Vacinas_Cat extends AppCompatActivity {

    private Toolbar toolbarcat;

    private ListView listaVacinas;
    private String[] vacinas = {"Vermífugo", "Anti-pulgas", "V4", "Anti-rábica", "Quádrupla Felina"};
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas__cat);

        toolbarcat = (Toolbar) findViewById(R.id.toolbar_vacinasCat);
        toolbarcat.setTitle("Vacinas");
        setSupportActionBar(toolbarcat);

        listaVacinas = (ListView) findViewById(R.id.listaVacinas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                vacinas);
        listaVacinas.setAdapter(adapter);
    }
}
