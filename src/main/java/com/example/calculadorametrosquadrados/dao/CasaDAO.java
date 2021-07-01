package com.example.calculadorametrosquadrados.dao;
import com.example.calculadorametrosquadrados.rest.entity.Casa;
import com.example.calculadorametrosquadrados.rest.entity.Comodo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

public class CasaDAO {

    private static List<Casa> casas = new ArrayList<Casa>();

    public List<Casa> getList(){
        return casas;
    }

    public void adicionar(Casa casa) {
        casas.add(casa);
    }

    public Casa get(long id) {
        Optional<Casa> casaOpt = casas.stream().filter(a -> a.getId() == id).findFirst();
        return casaOpt.orElse(null);
    }
}