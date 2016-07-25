package model.exemplo.com.br.consumirws;

import android.os.Bundle;


import java.io.Serializable;

public class Cliente implements Serializable{

    private int id;
    private String nome;
    private String endereco;
    private String latitude;
    private String longetitude;
    private int  bebida;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongetitude() {
        return longetitude;
    }

    public void setLongetitude(String longetitude) {
        this.longetitude = longetitude;
    }

    public int getBebida() {
        return bebida;
    }

    public void setBebida(int bebida) {
        this.bebida = bebida;
    }



}
