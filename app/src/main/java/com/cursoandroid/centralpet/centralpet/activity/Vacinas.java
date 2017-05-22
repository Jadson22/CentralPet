package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.cursoandroid.centralpet.centralpet.R;

public class Vacinas extends AppCompatActivity {

    private Toolbar toolbarVacina;

    private ImageView imgDog;
    private ImageView imgCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas);

        toolbarVacina = (Toolbar) findViewById(R.id.toolbar_vacinas);
        toolbarVacina.setTitle("Vacinas");
        setSupportActionBar(toolbarVacina);

        imgCat = (ImageView) findViewById(R.id.imgcat);
        imgDog = (ImageView) findViewById(R.id.imgdog);


        imgDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Vacinas.this, Vacinas_Dog.class);
                startActivity(it);
            }
        });

        imgCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Vacinas.this, Vacinas_Cat.class);
                startActivity(it);
            }
        });
    }
}
