package com.cursoandroid.centralpet.centralpet.activity.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.cursoandroid.centralpet.centralpet.activity.dominio.entidades.Compromissos;
import com.cursoandroid.centralpet.centralpet.activity.dominio.entidades.Perfil;

import java.util.Date;

/**
 * Created by L Moraes on 29/05/2017.
 */
public class RepositorioPerfil {

    private SQLiteDatabase con;

    public RepositorioPerfil(SQLiteDatabase con){

        this.con = con;
    }

    public void inserir(Perfil perfil){
        ContentValues values = new ContentValues();
        values.put("NOME", perfil.getNome());
        values.put("RACA", perfil.getRaca());
        values.put("DATA", perfil.getDatanasc().getTime());

        con.insertOrThrow("PERFIL", null, values);

    }


    public ArrayAdapter<Perfil> buscaPerfil(Context context){

        ArrayAdapter<Perfil> adpPerfil = new ArrayAdapter<Perfil>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = con.query("PERFIL", null, null, null, null, null, null);

        if(cursor.getCount() > 0 ){

            cursor.moveToFirst();

            do {

                Perfil perfil = new Perfil();
                perfil.setNome(cursor.getString(1));
                perfil.setRaca(cursor.getString(2));
                perfil.setDatanasc(new Date(cursor.getLong(3)));

                adpPerfil.add(perfil);

            }while (cursor.moveToNext());
        }
        return adpPerfil;
    }
}
