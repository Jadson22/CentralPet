package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;

public class MeusPets extends AppCompatActivity {

    private Toolbar toolbarMeusPets;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_pets);

        toolbarMeusPets = (Toolbar) findViewById(R.id.toolbar_meusPets);
        toolbarMeusPets.setTitle("Meus Pets");
        setSupportActionBar(toolbarMeusPets);


        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MeusPets.this, Modelo.class);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_meuspets, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:
                Intent intent = new Intent(this, MeusPetsCad.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
