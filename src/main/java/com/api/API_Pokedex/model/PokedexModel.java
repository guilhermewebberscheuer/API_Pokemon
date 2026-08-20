package com.api.API_Pokedex.model;

public class PokedexModel {
    private Long id;
    private String nome;
    private String descricao;
    private String classificacao;
    private String tipo1;
    private String tipo2;
    private Double peso;
    private Double altura;
    private String regioes;
    private Integer nivel;
    private Integer vida;
    private Integer vidaMaxima;
    private Integer ataque;
    private Integer defesa;
    private Integer velocidade;
    private String item;

    public PokedexModel(Long id, String nome, String descricao, String classificacao, String tipo1, String tipo2, Double peso, Double altura, String regioes, Integer nivel, Integer vida, Integer vidaMaxima, Integer ataque, Integer defesa, Integer velocidade, String item) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.peso = peso;
        this.altura = altura;
        this.regioes = regioes;
        this.nivel = nivel;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getRegioes() {
        return regioes;
    }

    public void setRegioes(String regioes) {
        this.regioes = regioes;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(Integer vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}