package com.example.calculadorametrosquadrados.rest.dto;

import com.example.calculadorametrosquadrados.dao.CasaDAO;
import com.example.calculadorametrosquadrados.rest.entity.Casa;
import com.example.calculadorametrosquadrados.rest.entity.Comodo;

import java.util.List;
import java.util.stream.Collectors;

public class CasaDTO {

    public String getNome() {
        return Nome;
    }

    public String getEnd() {
        return end;
    }

    public List<Comodo> getComodo() {
        return comodo;
    }

    public String Nome;

    public String end;

    public List<Comodo> comodo;

    public CasaDTO(String nome, String end, List<Comodo> comodo) {
        super();
        Nome = nome;
        this.end = end;
        this.comodo = comodo;
    }
    public CasaDTO(Casa casa){
        super();
        this.Nome = casa.getNome();
        this.comodo = casa.getComodo();
        this.end = casa.getEnd();
    }

    public static CasaDTO converteEntityToDTO(Casa casa){
        return new CasaDTO(casa.getNome(), casa.getEnd(), casa.getComodo());
    }
    public static Casa convertDTOToEntity(CasaDTO casaDTO, CasaDAO casaDAO){
        return new Casa(casaDAO.getList().size()+1, casaDTO.getNome(), casaDTO.getEnd(), casaDTO.getComodo());
    }
    public static List<CasaDTO> converteListDTO(List<Casa> casas){
        return casas.stream().map( a -> new CasaDTO(a)).collect(Collectors.toList());
    }
}