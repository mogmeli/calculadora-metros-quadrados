package com.example.calculadorametrosquadrados.rest.entity;

import java.util.List;

public class Casa {


    public Casa(long id, String nome, String end, List<Comodo> comodo) {
        this.id = id;
        this.nome = nome;
        this.end = end;
        this.comodo = comodo;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEnd() {
        return end;
    }

    public List<Comodo> getComodo() {
        return comodo;
    }

    private long id;
    private String nome;
    private String end;
    private List<Comodo> comodo;

}