package com.api.API_Pokedex.model;

import java.util.ArrayList;

public class GinasioModel {
    Integer id;
    String nome;
    ArrayList<TreinadorModel> treinadores = new ArrayList();
    String tipo;
    TreinadorModel lider;

    public GinasioModel(Integer id, String nome, ArrayList<TreinadorModel> treinadores, String tipo, TreinadorModel lider) {
        this.id = id;
        this.nome = nome;
        this.treinadores = treinadores;
        this.tipo = tipo;
        this.lider = lider;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<TreinadorModel> getTreinadores() {
        return treinadores;
    }

    public void setTreinadores(ArrayList<TreinadorModel> treinadores) {
        this.treinadores = treinadores;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TreinadorModel getLider() {
        return lider;
    }

    public void setLider(TreinadorModel lider) {
        this.lider = lider;
    }
}
