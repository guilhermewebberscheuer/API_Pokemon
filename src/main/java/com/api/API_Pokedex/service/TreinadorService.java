package com.api.API_Pokedex.service;

import com.api.API_Pokedex.model.PokedexModel;
import com.api.API_Pokedex.model.TreinadorModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/treinadores/actions")
public class TreinadorService {
    private final List<PokedexModel> pokemons = new ArrayList<>();
    private final List<TreinadorModel> treinadores = new ArrayList<>();


    @Operation(
            summary = "Andar",
            description = "O Treinador anda para 4 direções: Esquerda, Direita, Cima e Baixo"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "301",
                    description = "Treinador andou"
            ),
            @ApiResponse(
                    responseCode = "501",
                    description = "Erro: Treinador não andou"
            )
    })
    @GetMapping("/{id}/andar/{direcao}")
    public String andar(
            @Parameter(
                    description = "ID do Treinador que irá andar",
                    example = "1"
            )
            @PathVariable int id,

            @Parameter(
                    description = "Model do treinador",
                    example = ""
            )
            @RequestBody TreinadorModel treinador,

            @Parameter(
                    description = "Direção para qual o treinador vai andar (cima, baixo, esquerda, direita)",
                    example = "cima"
            )
            @PathVariable String direcao) {

        for(TreinadorModel entrada : treinadores){
            if(entrada.getId() == id){
                treinador = entrada;
            }
        }
        return treinador.getNome() + " andou para " + direcao;
    }

    //@PatchMapping("/{id}/adicionarPokemonTime/{idPokemon}")
    //public String adicionarPokemonTime(@PathVariable int id, @PathVariable int idPokemon, @RequestBody TreinadorModel treinador, @RequestBody PokedexModel pokemon) {
    //    treinador = null;
//
    //    for(TreinadorModel entrada : treinadores){
    //        if(entrada.getId() == id){
    //            treinador = entrada;
    //        }
    //    }
//
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons){
    //        if(entrada.getId() == idPokemon){
    //            pokemon = entrada;
    //        }
    //    }
//
    //    String mensagem = "";
    //    List<PokedexModel> timePokemon = treinador.getTimePokemon();
    //    if(treinador.tamanhoTimePokemon() == true){
    //        timePokemon.add(pokemon);
    //        treinador.setTimePokemon(timePokemon);
    //        mensagem = pokemon.getNome() + " adicionado ao time";
    //    }else{
    //        mensagem = "Time cheio";
    //    }
//
    //    return mensagem;
    //}

    //@PatchMapping("/{id}/curarTime")
    //public String curarTime(@PathVariable int id){
//
    //    TreinadorModel treinador = null;
//
    //    for(TreinadorModel entrada : treinadores){
    //        if(entrada.getId() == id) {
    //            treinador = entrada;
    //        }
    //    }
    //    for (int i = 0; i <= pokemons.size(); i++){
    //        if ()
    //    }
    //}
}
