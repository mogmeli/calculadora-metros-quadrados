package com.example.calculadorametrosquadrados.rest.dto;

import com.example.calculadorametrosquadrados.dao.CasaDAO;
import com.example.calculadorametrosquadrados.dao.ComodoDAO;
import com.example.calculadorametrosquadrados.rest.entity.Comodo;

public class ComodoDTO {
    private String nome;
    private int largura;

    public String getNome() {
        return nome;
    }

    public int getLargura() {
        return largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    private int comprimento;

    public ComodoDTO(String nome, int largura, int comprimento){
        super();
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public ComodoDTO(Comodo comodo){
        super();
        this.nome = comodo.getNome();
        this.largura = comodo.getLargura();
        this.comprimento = comodo.getComprimento();
    }

    public static ComodoDTO converteEntityToDTO(Comodo comodo){
        return new ComodoDTO(comodo.getNome(), comodo.getLargura(), comodo.getComprimento());
    }

    public static Comodo converteDTOtoEntity(ComodoDTO comodoDTO, ComodoDAO comodoDAO){
        return new Comodo(comodoDAO.getList().size()+1,  comodoDTO.getNome(), comodoDTO.getLargura(), comodoDTO.getComprimento());
    }

}