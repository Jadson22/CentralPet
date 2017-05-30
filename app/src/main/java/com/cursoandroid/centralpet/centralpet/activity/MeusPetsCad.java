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


        Bundle bundle =  getIntent().getExtras();
        if((bundle != null) && (bundle.containsKey("PERFIL"))){
            perfil = (Perfil)bundle.getSerializable("PERFIL");
            preencheDados2();
        }else{
            perfil = new Perfil();
        }

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

        if(perfil.getId() != 0 )
        menu.getItem(0).setVisible(true);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.salvar:
                salvar();
                finish();
                break;

            case R.id.excluir:
                excluir();
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void preencheDados2(){

        edtnome.setText(perfil.getNome());
        edtraca.setText(perfil.getRaca());
        edtdatanasc.setText(null);
    }

    private void excluir(){

     try{

         repositorioPerfil.excluir(perfil.getId());
    }catch (Exception ex){

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage("erro ao inserir os dados " + ex.getMessage());
        dlg.setNeutralButton("ok", null);
        dlg.show();
    }
    }

    private void salvar(){

        try {
            perfil = new Perfil();

            perfil.setNome(edtnome.getText().toString());
            perfil.setRaca(edtraca.getText().toString());
            //Date date = new Date();
            perfil.setDatanasc(null);

            if(perfil.getId() == 0)
            repositorioPerfil.inserir(perfil);
            else
                repositorioPerfil.alterar2(perfil);

        }catch (Exception ex){

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage("erro ao inserir os dados " + ex.getMessage());
        dlg.setNeutralButton("ok", null);
        dlg.show();
    }
    }
}
