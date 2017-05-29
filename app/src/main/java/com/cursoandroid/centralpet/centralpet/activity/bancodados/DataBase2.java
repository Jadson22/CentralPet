package com.cursoandroid.centralpet.centralpet.activity.bancodados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by L Moraes on 29/05/2017.
 */
public class DataBase2 extends SQLiteOpenHelper {

    public DataBase2(Context context){

        super(context, "PERFIL", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(ScriptSQL2.getCreatePerfil());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
