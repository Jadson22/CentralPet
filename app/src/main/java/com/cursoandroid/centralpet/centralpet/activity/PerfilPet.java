package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;
import com.cursoandroid.centralpet.centralpet.activity.bancodados.DataBase;
import com.cursoandroid.centralpet.centralpet.activity.dominio.RepositorioComp;
import com.cursoandroid.centralpet.centralpet.activity.dominio.entidades.Compromissos;

public class PerfilPet extends AppCompatActivity {

    private TextView nome, compromisso, tipo, outro, data, hora, local, obs;
    private Toolbar toolbarperfil;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioComp repositorioComp;
    private Compromissos compromissos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_pet);

        toolbarperfil = (Toolbar) findViewById(R.id.toolbar_perfil);
        toolbarperfil.setTitle("Central Pet");
        setSupportActionBar(toolbarperfil);

        nome = (TextView) findViewById(R.id.nomeid);
        compromisso = (TextView) findViewById(R.id.compromissoid);
        tipo = (TextView) findViewById(R.id.tipoid);
        outro = (TextView) findViewById(R.id.outroid);
        data = (TextView) findViewById(R.id.dataid);
        hora = (TextView) findViewById(R.id.horarioid);
        local = (TextView) findViewById(R.id.localid);
        obs = (TextView) findViewById(R.id.obsid);


        Bundle bundle = getIntent().getExtras();
        if((bundle != null)&&(bundle.containsKey("COMPROMISSO"))){
            compromissos = (Compromissos) bundle.getSerializable("COMPROMISSO");
            preencheDados();
        }else{
            compromissos = new Compromissos();
        }
    }

    private void preencheDados(){

        nome.setText(compromissos.getNome());
        compromisso.setText(compromissos.getCompromisso());
        //spnTipo.setSelection(Integer.parseInt(compromissos.getTipo()));
        //tipo.setText(Integer.parseInt(compromissos.getTipo()));
        outro.setText(compromissos.getOutro());
        //DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);
        //String dt = format.format(compromissos.getData());
        //editData.setText(dt);
        data.setText(null);
        hora.setText(null);
        local.setText(compromissos.getLocal());
        obs.setText(compromissos.getOutro());
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
                Intent intent = new Intent(PerfilPet.this, CadastroAgenda.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
