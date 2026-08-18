package com.api.API_Pokedex.model;

import java.util.ArrayList;

public class TreinadorModel {
    Integer id;
    String nome;
    ArrayList<PokedexModel> timePokemon = new ArrayList();

    public TreinadorModel(Integer id, String nome, ArrayList<PokedexModel> timePokemon) {
        this.id = id;
        this.nome = nome;
        this.timePokemon = timePokemon;
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

    public ArrayList<PokedexModel> getTimePokemon() {
        return timePokemon;
    }

    public void setTimePokemon(ArrayList<PokedexModel> timePokemon) {
        this.timePokemon = timePokemon;
    }
}
