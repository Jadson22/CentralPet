package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.function.ToLongBiFunction;



public class tela_menu extends AppCompatActivity{

    private AdView adView;

    private Toolbar toolbar_menu;

    private ImageView agenda;
    private ImageView marcados;
    private ImageView vacinas;
    private ImageView alimentacao;
    private ImageView duvidas_freq;
    private ImageView suporte;
    private ImageView meusPets;
    private ImageView clinicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);

        toolbar_menu = (Toolbar) findViewById(R.id.toolbar_menu);
        agenda = (ImageView) findViewById(R.id.agenda_id);
        marcados = (ImageView) findViewById(R.id.agenda_salva_id);
        vacinas = (ImageView) findViewById(R.id.vacina_id);
        duvidas_freq = (ImageView) findViewById(R.id.duvida_id);
        suporte =  (ImageView) findViewById(R.id.suporte_id);
        meusPets = (ImageView) findViewById(R.id.meusPets_id);
        clinicas= (ImageView) findViewById(R.id.mapaID);

        //Toolbar
        toolbar_menu.setTitle("Central Pet");
        setSupportActionBar(toolbar_menu);




        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            String nome = user.getDisplayName();
            String email = user.getEmail();
        } else {
            goLoginScreen();
        }


        //chamar a agenda
        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_menu.this, CadastroAgenda.class);
                startActivity(intent);
            }
        });

        //chamar o cadastro de agenda
        marcados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_menu.this, SalvosAgenda.class);
                startActivity(intent);
            }
        });

        //chamar a tela vacinas
        vacinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_menu.this, Vacinas.class);
                startActivity(intent);
            }
        });

        //chamar a tela de duvidas
        duvidas_freq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_menu.this, Duvidas_freq.class);
                startActivity(intent);
            }
        });
        //Chamar a tela de suporte
        suporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_menu.this, Suporte.class);
                startActivity(intent);
            }
        });
        //chamar a tela meus Pets
        meusPets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_menu.this, MeusPets.class);
                startActivity(intent);
            }
        });

        clinicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_menu.this, MapaClinicaActivity.class);
                startActivity(intent);
            }
        });






        //Anúncios
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
    private void goLoginScreen(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    //toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_deslogar:
                deslogar_usuario();
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }

    private void deslogar_usuario(){
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

}


