package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.cursoandroid.centralpet.centralpet.R;
import com.cursoandroid.centralpet.centralpet.activity.bancodados.DataBase2;
import com.cursoandroid.centralpet.centralpet.activity.dominio.RepositorioComp;
import com.cursoandroid.centralpet.centralpet.activity.dominio.RepositorioPerfil;
import com.cursoandroid.centralpet.centralpet.activity.dominio.entidades.Perfil;

public class MeusPets extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Toolbar toolbarMeusPets;
    private ListView lstPet;
    private ArrayAdapter<Perfil> adpPerfil;

    private DataBase2 dataBase2;
    private SQLiteDatabase con;
    private RepositorioPerfil repositorioPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_pets);

        toolbarMeusPets = (Toolbar) findViewById(R.id.toolbar_meusPets);
        toolbarMeusPets.setTitle("Meus Pets");
        setSupportActionBar(toolbarMeusPets);

        lstPet = (ListView) findViewById(R.id.listView);
        lstPet.setOnItemClickListener(this);

        try {
            dataBase2 = new DataBase2(this);
            con = dataBase2.getWritableDatabase();

            repositorioPerfil = new RepositorioPerfil(con);


            adpPerfil = repositorioPerfil.buscaPerfil(this);

            lstPet.setAdapter(adpPerfil);


        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("erro " + ex.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();

        }

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
                startActivityForResult(intent, 0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adpPerfil = repositorioPerfil.buscaPerfil(this);

        lstPet.setAdapter(adpPerfil);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Perfil perfil = adpPerfil.getItem(i);

        Intent intent = new Intent(this, Modelo.class);
        intent.putExtra("PERFIL", perfil);
        startActivityForResult(intent, 0);


    }
}
