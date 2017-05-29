package com.cursoandroid.centralpet.centralpet.activity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.cursoandroid.centralpet.centralpet.R;
import com.cursoandroid.centralpet.centralpet.activity.bancodados.DataBase2;
import com.cursoandroid.centralpet.centralpet.activity.dominio.RepositorioPerfil;
import com.cursoandroid.centralpet.centralpet.activity.dominio.entidades.Perfil;

import java.util.Date;

public class MeusPetsCad extends AppCompatActivity {

    private Toolbar toolbarMeusPetsCad;
    private EditText edtnome, edtraca, edtdatanasc;

    private DataBase2 dataBase2;
    private SQLiteDatabase con;
    private RepositorioPerfil repositorioPerfil;
    private Perfil perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_pets_cad);

        toolbarMeusPetsCad = (Toolbar) findViewById(R.id.toolbar_meusPets_cad);
        toolbarMeusPetsCad.setTitle("Cadastro");
        setSupportActionBar(toolbarMeusPetsCad);


        edtnome = (EditText) findViewById(R.id.editNome);
        edtraca = (EditText) findViewById(R.id.editRaca);
        edtdatanasc = (EditText) findViewById(R.id.editDataNascimento);

        try {
            dataBase2 = new DataBase2(this);
            con = dataBase2.getWritableDatabase();

            repositorioPerfil = new RepositorioPerfil(con);


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
        inflater.inflate(R.menu.menu_cad_perfil, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.salvar:
                if(perfil == null){
                    inserir();
                }
                finish();
                break;

            case R.id.excluir:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void inserir(){

        try {
            perfil = new Perfil();

            perfil.setNome(edtnome.getText().toString());
            perfil.setRaca(edtraca.getText().toString());
            Date date = new Date();
            perfil.setDatanasc(date);

            repositorioPerfil.inserir(perfil);
        }catch (Exception ex){

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage("erro ao inserir os dados " + ex.getMessage());
        dlg.setNeutralButton("ok", null);
        dlg.show();

    }
    }
}
