package com.example.calculadorametrosquadrados.dao;

import com.example.calculadorametrosquadrados.rest.entity.Casa;
import com.example.calculadorametrosquadrados.rest.entity.Comodo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ComodoDAO {
    private static List<Comodo> comodos = new ArrayList<Comodo>();

    public List<Comodo> getList(){
        return comodos;
    }

    public void adicionar(Comodo comodo) {
        comodos.add(comodo);
    }

    public Comodo get(long id) {
        Optional<Comodo> comodoOpt = comodos.stream().filter(a -> a.getId() == id).findFirst();
        return comodoOpt.orElse(null);
    }
}