package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cursoandroid.centralpet.centralpet.R;

public class Vermifugo extends AppCompatActivity {

    private Toolbar toolbar_verm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vermifugo);

        toolbar_verm = (Toolbar) findViewById(R.id.toolbar_verm);
        toolbar_verm.setTitle("Vermífugo");
        setSupportActionBar(toolbar_verm);
    }
}
