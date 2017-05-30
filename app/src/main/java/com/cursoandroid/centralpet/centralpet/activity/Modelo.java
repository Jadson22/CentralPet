package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;
import com.cursoandroid.centralpet.centralpet.activity.bancodados.DataBase2;
import com.cursoandroid.centralpet.centralpet.activity.dominio.RepositorioPerfil;
import com.cursoandroid.centralpet.centralpet.activity.dominio.entidades.Perfil;

public class Modelo extends AppCompatActivity {

    private Toolbar toolbarmodelo;
    private TextView nome, raca, dtnasc;

    private DataBase2 dataBase2;
    private SQLiteDatabase con;
    private RepositorioPerfil repositorioPerfil;
    private Perfil perfil;

    private ArrayAdapter<Perfil> adpPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelo);

        toolbarmodelo = (Toolbar) findViewById(R.id.toolbar_modelo);
        toolbarmodelo.setTitle("Meus Pets");
        setSupportActionBar(toolbarmodelo);

        nome = (TextView) findViewById(R.id.edtnome);
        raca = (TextView) findViewById(R.id.edtraca);
        dtnasc = (TextView) findViewById(R.id.edtnasc);

        Bundle bundle =  getIntent().getExtras();
        if((bundle != null) && (bundle.containsKey("PERFIL"))){
            perfil = (Perfil)bundle.getSerializable("PERFIL");
            preencheDados2();
        }else{
            perfil = new Perfil();
        }
    }

    private void preencheDados2(){

        nome.setText(perfil.getNome());
        raca.setText(perfil.getRaca());
        dtnasc.setText(null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_perfil, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit:
                Intent intent = new Intent(Modelo.this, MeusPetsCad.class);
                intent.putExtra("PERFIL", perfil);
                startActivityForResult(intent, 0);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
