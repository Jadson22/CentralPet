package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cursoandroid.centralpet.centralpet.R;

import java.util.ArrayList;
import java.util.List;

public class Vacinas_Dog extends AppCompatActivity {

    private Toolbar toolbardog;
    private ListView listaVacinas;
    private String[] vacinas = {"Vermífugo", "Anti-pulgas", "V8 ou V10", "Tosse", "Anti-rábica", "Giardíase", "Gripe canina"};
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas__dog);

        toolbardog = (Toolbar) findViewById(R.id.toolbar_vacinasDog);
        toolbardog.setTitle("Vacinas");
        setSupportActionBar(toolbardog);

        listaVacinas = (ListView) findViewById(R.id.listaVacinas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                vacinas);
        listaVacinas.setAdapter(adapter);

        listaVacinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               switch (i){
                   case 0: vermifugo();
                       break;
                   case 1: anti_pulgas();
                       break;
               }
            }
        });
    }

    public void vermifugo(){

        Intent it = new Intent(Vacinas_Dog.this, Vermifugo.class);
        startActivity(it);
    }

    public void anti_pulgas(){
        Intent it = new Intent(Vacinas_Dog.this, Anti_Pulgas.class);
        startActivity(it);
    }
}
