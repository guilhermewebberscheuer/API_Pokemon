package com.api.API_Pokedex.model;

import java.util.ArrayList;
import java.util.List;

public class TreinadorModel {
    private Integer id;
    private String nome;
    private List<PokedexModel> timePokemon = new ArrayList<>();
    private List<String> itens = new ArrayList<>();

    public TreinadorModel(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<PokedexModel> getTimePokemon() {
        return timePokemon;
    }

    public void setTimePokemon(List<PokedexModel> timePokemon) {
        this.timePokemon = timePokemon;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public boolean temEspacoNoTime() {
        return this.timePokemon != null && this.timePokemon.size() < 6;
    }
}
