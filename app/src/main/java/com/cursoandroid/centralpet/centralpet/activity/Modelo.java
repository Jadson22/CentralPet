package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cursoandroid.centralpet.centralpet.R;

public class Modelo extends AppCompatActivity {

    private Toolbar toolbarmodelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelo);

        toolbarmodelo = (Toolbar) findViewById(R.id.toolbar_modelo);
        toolbarmodelo.setTitle("Meus Pets");
        setSupportActionBar(toolbarmodelo);
    }
}
