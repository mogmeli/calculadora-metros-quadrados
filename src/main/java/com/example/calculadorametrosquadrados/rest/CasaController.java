package com.example.calculadorametrosquadrados.rest;

import com.example.calculadorametrosquadrados.dao.CasaDAO;
import com.example.calculadorametrosquadrados.dao.ComodoDAO;
import com.example.calculadorametrosquadrados.rest.dto.CasaDTO;
import com.example.calculadorametrosquadrados.rest.entity.Casa;
import com.example.calculadorametrosquadrados.rest.entity.Comodo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
public class CasaController {


    private CasaDAO casaDAO = new CasaDAO();
    private ComodoDAO comodoDAO = new ComodoDAO();

    @PostMapping
    public ResponseEntity<CasaDTO> cadastra(@RequestBody CasaDTO casaDTO, UriComponentsBuilder uriBuilder){
        Casa casa = CasaDTO.convertDTOToEntity(casaDTO, casaDAO);
        casaDAO.adicionar(casa);
        URI uri = uriBuilder.path("/casa/{id}").buildAndExpand(casa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @RequestMapping("/casa/{id}")
    public CasaDTO getCasa(@PathVariable long id){
        Casa casa = casaDAO.get(id);
        CasaDTO casaDTO = CasaDTO.converteEntityToDTO(casa);
        return casaDTO;
    }
    @GetMapping("/casas")
    public List<CasaDTO> getAllCasas(){
        List<Casa> casas = casaDAO.getList();
        List<CasaDTO> dtos = CasaDTO.converteListDTO(casas);
        return dtos;
    }

    @GetMapping("/{id}/totalmetros")
    public int totalMetrosQuadrados(@PathVariable int id){
        Casa casa = casaDAO.get(id);
        CasaDTO casaDTO = CasaDTO.converteEntityToDTO(casa);
        List<Comodo> com = casaDTO.getComodo();
        int contador = 0;
        for( Comodo comodo : com){
            contador += comodo.getComprimento() * comodo.getLargura();
        }
        return contador;
    }

    @GetMapping("/{id}/totalvalor")
    public long valorDaCasa(@PathVariable int id){
        Casa casa = casaDAO.get(id);
        CasaDTO casaDTO = CasaDTO.converteEntityToDTO(casa);
        List<Comodo> com = casaDTO.getComodo();
        int contador = 0;
        for( Comodo comodo : com){
            contador += comodo.getComprimento() * comodo.getLargura();
        }
        return contador * 800L;
    }

    @GetMapping("/{id}/maiorcomodo")
    public String maiorComodo(@PathVariable int id){
        Casa casa = casaDAO.get(id);
        CasaDTO casaDTO = CasaDTO.converteEntityToDTO(casa);
        List<Comodo> com = casaDTO.getComodo();
        List<Integer> maiorComodo = new ArrayList<Integer>();
        for( Comodo comodo : com){
            maiorComodo.add(comodo.getComprimento() * comodo.getLargura());
        }
        Integer max = Collections.max(maiorComodo);
        return "O maior comodo da casa " + casaDTO.getNome() + " tem " + max + " metros quadrados";
    }

    @GetMapping("/{id}/metrosquadradoscomodos")
    public StringBuilder metrosQuadradosComodos(@PathVariable int id){
        Casa casa = casaDAO.get(id);
        CasaDTO casaDTO = CasaDTO.converteEntityToDTO(casa);
        List<Comodo> com = casaDTO.getComodo();
        Map<Integer, Integer> metrosQuadrados = new HashMap<>();
        int counter = 0;
        for( Comodo comodo : com){
            metrosQuadrados.put(counter, comodo.getComprimento() * comodo.getLargura());
            counter++;
        }
        StringBuilder sb = new StringBuilder();
        metrosQuadrados.forEach( (k,v) -> sb.append("comodo: " + k + 1 + ", metros quadrados: " + v + "\n"));
        return sb;
    }
}