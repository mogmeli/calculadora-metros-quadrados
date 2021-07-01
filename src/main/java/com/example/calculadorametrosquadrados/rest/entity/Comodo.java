package com.example.calculadorametrosquadrados.rest.entity;

public class Comodo {

    private long id;

    public long getId() {
        return id;
    }

    private String nome;
    private int largura, comprimento;

    public String getNome() {
        return nome;
    }

    public int getLargura() {
        return largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public Comodo(long id, String nome, int largura, int comprimento){
        super();
        this.id = id;
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
    }
}