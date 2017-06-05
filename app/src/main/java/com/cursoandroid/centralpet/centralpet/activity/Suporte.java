package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;

public class Suporte extends AppCompatActivity {

    private Toolbar toolbar_suporte;
    RelativeLayout compartilheid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suporte);

        toolbar_suporte = (Toolbar) findViewById(R.id.toolbar_suporte);
        toolbar_suporte.setTitle("Suporte");
        setSupportActionBar(toolbar_suporte);

        compartilheid = (RelativeLayout) findViewById(R.id.compartilheid);
        compartilheid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                it.putExtra(Intent.EXTRA_TEXT, "Baixe o aplicativo Central Pet!");
                startActivity(it);
            }
        });



    }
}
