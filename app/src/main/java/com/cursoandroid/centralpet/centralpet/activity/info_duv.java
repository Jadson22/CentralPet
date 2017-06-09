package com.cursoandroid.centralpet.centralpet.activity;

/**
 * Created by L Moraes on 08/06/2017.
 */
public class info_duv {

    private String nome;
    private String valor;

    public info_duv(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
