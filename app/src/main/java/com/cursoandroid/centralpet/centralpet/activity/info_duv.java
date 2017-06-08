package com.cursoandroid.centralpet.centralpet.activity;

/**
 * Created by L Moraes on 08/06/2017.
 */
public class info_duv {

    private String nome;
    private Double valor;

    public info_duv(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
