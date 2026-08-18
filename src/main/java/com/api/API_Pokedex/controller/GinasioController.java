package com.api.API_Pokedex.controller;

import com.api.API_Pokedex.model.GinasioModel;
import com.api.API_Pokedex.model.PokedexModel;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ginasios")
public class GinasioController {
    private final List<GinasioModel> ginasios = new ArrayList<>();

    @PostMapping
    public GinasioModel adicionarGinasio(@RequestBody GinasioModel ginasio) {
        ginasios.add(ginasio);
        return ginasio;
    }

    @GetMapping
    public List<GinasioModel> listarGinasio(){
        return ginasios;
    }

    @GetMapping("/{id}")
    public GinasioModel buscarGinasioId(@PathVariable int id){
        GinasioModel ginasio = null;

        for(GinasioModel entrada : ginasios){
            if(entrada.getId() == id){
                ginasio = entrada;
            }
        }

        return ginasio;
    }

    @PutMapping ("/{id}")
    public GinasioModel atualizarGinasio(
            @Parameter(
                    description = "ID do Ginásio que será atualizado",
                    example = "1"
            )
            @PathVariable int id, @RequestBody GinasioModel ginasio) {
        int index = 0;

        for(GinasioModel entrada : ginasios){
            if(entrada.getId() == id){
                index = ginasios.indexOf(entrada);
            }
        }

        GinasioModel set = ginasios.set(index, ginasio);
        return ginasio;
    }

    @DeleteMapping("/{id}")
    public void deletarGinasioId(
            @Parameter(
                    description = "ID do Ginásio que será removido",
                    example = "1"
            )
            @PathVariable int id){


        for(GinasioModel entrada : ginasios){
            if(entrada.getId() == id){
                ginasios.remove(entrada);
            }
        }

    }
}
