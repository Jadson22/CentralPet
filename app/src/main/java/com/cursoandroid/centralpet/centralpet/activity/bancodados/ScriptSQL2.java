package com.cursoandroid.centralpet.centralpet.activity.bancodados;

/**
 * Created by L Moraes on 29/05/2017.
 */
public class ScriptSQL2 {

    public static String getCreatePerfil(){

        StringBuilder sqlBuilder2 = new StringBuilder();


        sqlBuilder2.append("CREATE TABLE IF NOT EXISTS PERFIL( ");
        sqlBuilder2.append("_id          INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder2.append("NOME         VARCHAR (50), ");
        sqlBuilder2.append("RACA         VARCHAR (50), ");
        sqlBuilder2.append("DATA         DATE ");
        sqlBuilder2.append(");");

        return sqlBuilder2.toString();
    }

}
