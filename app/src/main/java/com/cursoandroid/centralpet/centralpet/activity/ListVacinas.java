package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bumptech.glide.Glide;
import com.cursoandroid.centralpet.centralpet.R;
import com.cursoandroid.centralpet.centralpet.activity.PerfilPets.CadastroMeusPets;
import com.cursoandroid.centralpet.centralpet.activity.PerfilPets.FoodList;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class ListVacinas extends AppCompatActivity {

    private GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    private Toolbar toolbarlistVacinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vacinas);

        toolbarlistVacinas = (Toolbar) findViewById(R.id.toolbar_listVacinas);
        toolbarlistVacinas.setTitle("Minhas Vacinas");
        setSupportActionBar(toolbarlistVacinas);


        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("aaaaaaaaaaaaaaaa").withEmail("adsd@sdasdasd").withIcon(getResources().getDrawable(R.drawable.fotoperfil))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Vacinas");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Meus Pets");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Lista");
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Clínicas");
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Dúvidas");
        SecondaryDrawerItem item6 = new SecondaryDrawerItem().withIdentifier(6).withName("Suporte");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbarlistVacinas)
                .addDrawerItems(
                        item1, item2, item3, item4,
                        new DividerDrawerItem(),
                        item5
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch (position){
                            case 1: Intent intent = new Intent(getApplicationContext(), ListVacinas.class);
                                startActivity(intent);
                                break;
                            case 2: Intent intent2 = new Intent(getApplicationContext(), CadastroMeusPets.class);
                                startActivity(intent2);
                                break;
                            case 3: Intent intent3 = new Intent(getApplicationContext(), FoodList.class);
                                startActivity(intent3);
                                break;
                            case 5: Intent intent5 = new Intent(getApplicationContext(), Suporte.class);
                                startActivity(intent5);
                                break;
                        }
                        return true;
                    }
                })
                .build();

    }
}
