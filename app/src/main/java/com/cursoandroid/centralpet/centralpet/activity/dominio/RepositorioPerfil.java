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

    private ContentValues preencheContentValues2(Perfil perfil){

        ContentValues values = new ContentValues();
        values.put("NOME", perfil.getNome());
        values.put("RACA", perfil.getRaca());
        values.put("DATA", "22");

        return values;
    }


    public void alterar2 (Perfil perfil){

        ContentValues values = preencheContentValues2(perfil);
        con.update("PERFIL", values, "_id = ?", new String[]{String.valueOf(perfil.getId())});
    }

    public void inserir(Perfil perfil){

        ContentValues values = preencheContentValues2(perfil);
        con.insertOrThrow("PERFIL", null, values);
    }

    public void excluir(long id){
        con.delete("PERFIL", "_id = ?", new String[]{String.valueOf(id)});
    }


    public ArrayAdapter<Perfil> buscaPerfil(Context context){

        ArrayAdapter<Perfil> adpPerfil = new ArrayAdapter<Perfil>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = con.query("PERFIL", null, null, null, null, null, null);

        if(cursor.getCount() > 0 ){

            cursor.moveToFirst();

            do {

                Perfil perfil = new Perfil();
                perfil.setId(cursor.getLong(0));
                perfil.setNome(cursor.getString(1));
                perfil.setRaca(cursor.getString(2));
                perfil.setDatanasc(null);

                adpPerfil.add(perfil);

            }while (cursor.moveToNext());
        }
        return adpPerfil;
    }
}
