package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cursoandroid.centralpet.centralpet.R;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class tela_menu extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private AdView adView;

    private Toolbar toolbar_menu;

    private ImageView agenda;
    private ImageView marcados;
    private ImageView vacinas;
    private ImageView duvidas_freq;
    private ImageView suporte;
    private ImageView meusPets;
    private ImageView clinicas;

    private GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

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

        //if(AccessToken.getCurrentAccessToken() == null){
        //    goLoginScreen();
        //}

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){

                }else{
                    goLoginScreen();
                }
            }
        };



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
                Intent intent = new Intent(tela_menu.this, ListVacinas.class);
                startActivity(intent);
            }
        });

        //chamar a tela de duvidas / vacinas de cao ou gato
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


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }


    private void goLoginScreen(){
        Intent intent = new Intent(this, MainActivity.class);
       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
       startActivity(intent);
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
        public void deslogar_usuario(){
        //LoginManager.getInstance().logOut();

            firebaseAuth.signOut();
            Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                @Override
                public void onResult(@NonNull Status status) {
                    if(status.isSuccess()){
                        goLoginScreen();
                    }else{
                        Toast.makeText(getApplicationContext(), "Não foi possivel encerrar seção", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener != null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }
}


