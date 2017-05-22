package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cursoandroid.centralpet.centralpet.R;

public class Vacinas_Dog extends AppCompatActivity {

    private Toolbar toolbardog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas__dog);

        toolbardog = (Toolbar) findViewById(R.id.toolbar_vacinasDog);
        toolbardog.setTitle("Vacinas");
        setSupportActionBar(toolbardog);
    }
}
