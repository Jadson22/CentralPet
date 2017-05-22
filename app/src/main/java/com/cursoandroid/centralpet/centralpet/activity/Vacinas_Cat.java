package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cursoandroid.centralpet.centralpet.R;

public class Vacinas_Cat extends AppCompatActivity {

    private Toolbar toolbarcat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas__cat);

        toolbarcat = (Toolbar) findViewById(R.id.toolbar_vacinasCat);
        toolbarcat.setTitle("Vacinas");
        setSupportActionBar(toolbarcat);
    }
}
