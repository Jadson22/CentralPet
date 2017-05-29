package com.cursoandroid.centralpet.centralpet.activity.dominio.entidades;

import java.util.Date;

/**
 * Created by L Moraes on 29/05/2017.
 */
public class Perfil {

    private long id;
    private String nome;
    private String raca;
    private Date datanasc;

    public Perfil(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    @Override
    public String toString(){

        return "Nome: " + nome +"\nRaça: " + raca + "\nData Nascimento: " + datanasc;
    }
}
