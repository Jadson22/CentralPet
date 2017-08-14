package com.cursoandroid.centralpet.centralpet.activity.PerfilPets;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class Pet {
    private int id;
    private String name;
    private String sexo;
    private String raca;
    private String tipo;
    private String idade;
    private byte[] image;

    public Pet(int id, String name, String sexo, String raca, String tipo, String idade, byte[] image) {
        this.id = id;
        this.name = name;
        this.sexo = sexo;
        this.raca = raca;
        this.tipo = tipo;
        this.idade = idade;
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
