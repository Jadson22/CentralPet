package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cursoandroid.centralpet.centralpet.R;

public class ListVacinas extends AppCompatActivity {

    private Toolbar toolbarlistVacinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vacinas);

        toolbarlistVacinas = (Toolbar) findViewById(R.id.toolbar_listVacinas);
        toolbarlistVacinas.setTitle("Minhas Vacinas");
        setSupportActionBar(toolbarlistVacinas);
    }
}
