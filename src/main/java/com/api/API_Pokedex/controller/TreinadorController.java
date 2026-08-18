package com.api.API_Pokedex.controller;

import com.api.API_Pokedex.model.GinasioModel;
import com.api.API_Pokedex.model.TreinadorModel;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/treinadores")
public class TreinadorController {


    private final List<TreinadorModel> treinadores = new ArrayList<>();

    @PostMapping
    public TreinadorModel adicionarTreinador(@RequestBody TreinadorModel treinador) {
        treinadores.add(treinador);
        return treinador;
    }

    @GetMapping
    public List<TreinadorModel> listarTreinadores() {
        return treinadores;
    }

    @GetMapping("/{id}")
    public TreinadorModel buscarTreinadorId(@PathVariable int id){
        TreinadorModel treinador = null;

        for(TreinadorModel entrada : treinadores){
            if(entrada.getId() == id){
                treinador = entrada;
            }
        }

        return treinador;
    }

    @PutMapping("/{id}")
    public TreinadorModel atualizarTreinador(
            @Parameter(
                    description = "ID do Treinador que será atualizado",
                    example = "1"
            )
            @PathVariable int id, @RequestBody TreinadorModel treinador) {
        int index = 0;

        for(TreinadorModel entrada : treinadores){
            if(entrada.getId() == id){
                index = treinadores.indexOf(entrada);
            }
        }

        TreinadorModel set = treinadores.set(index, treinador);
        return treinador;
    }

    @DeleteMapping("/{id}")
    public void deletarTreinadorId(
            @Parameter(
                    description = "ID do Treinador que será removido",
                    example = "1"
            )
            @PathVariable int id){


        for(TreinadorModel entrada : treinadores){
            if(entrada.getId() == id){
                treinadores.remove(entrada);
            }
        }

    }
}
