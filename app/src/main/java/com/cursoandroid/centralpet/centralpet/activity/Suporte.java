package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cursoandroid.centralpet.centralpet.R;

public class Suporte extends AppCompatActivity {

    private Toolbar toolbar_suporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suporte);

        toolbar_suporte = (Toolbar) findViewById(R.id.toolbar_suporte);
        toolbar_suporte.setTitle("Suporte");
        setSupportActionBar(toolbar_suporte);

    }
}
