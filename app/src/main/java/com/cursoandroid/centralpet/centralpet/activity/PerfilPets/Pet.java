package com.cursoandroid.centralpet.centralpet.activity.PerfilPets;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class Pet {
    private int id;
    private String name;
    private String raca;
    private String idade;
    private String sexo;
    private String tipo;
    private byte[] image;

    public Pet(int id, String name, String raca, String idade, String sexo, String tipo, byte[] image) {
        this.id = id;
        this.name = name;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.tipo = tipo;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
