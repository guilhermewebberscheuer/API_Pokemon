package com.api.API_Pokedex.service;

import com.api.API_Pokedex.model.PokedexModel;
import com.api.API_Pokedex.model.TreinadorModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreinadorService {
    private final List<TreinadorModel> treinadores = new ArrayList<>();

    private final PokedexService pokedexService;

    public TreinadorService(PokedexService pokedexService) {

        this.pokedexService = pokedexService;
    }

    public String adicionarTreinador(TreinadorModel treinador) {

        if (treinador.getTimePokemon() == null) {
            treinador.setTimePokemon(new ArrayList<>());
        }

        if (treinador.getItens() == null) {
            treinador.setItens(new ArrayList<>());
        }

        treinadores.add(treinador);

        return treinador.getNome() + " cadastrado com sucesso!";
    }

    public List<TreinadorModel> listarTreinadores() {

        return treinadores;
    }

    public TreinadorModel buscarTreinadorPorId(Integer id) {

        for (TreinadorModel treinador : treinadores) {

            if (treinador.getId().equals(id)) {
                return treinador;
            }
        }
        return null;
    }

    public String atualizarTreinador(
            Integer id,
            TreinadorModel treinador) {

        for (int i = 0; i < treinadores.size(); i++) {
            if (treinadores.get(i).getId().equals(id)) {
                treinadores.set(i, treinador);
                return treinador.getNome() + " atualizado com sucesso!";
            }
        }

        return "Treinador não encontrado!";
    }

    public String deletarTreinador(Integer id) {
        TreinadorModel treinador = buscarTreinadorPorId(id);

        if (treinador == null){
            return "Treinador não encontrado!";
        }

        treinadores.remove(treinador);

        return "Treinador deletado com sucesso!";
    }

    public String adicionarPokemonTime(
            Integer idTreinador,
            Long idPokemon ){

        TreinadorModel treinador = buscarTreinadorPorId(idTreinador);

        if(treinador == null){
            return "Treinador não encontrado!";
        }

        PokedexModel pokemon =  pokedexService.buscarPokemonPorId(idPokemon);

        if(pokemon == null){
            return "Pokémon não encontrado!";
        }

        if(!treinador.temEspacoNoTime()){
            return "Time cheio";
        }

        treinador.getTimePokemon().add(pokemon);

        return pokemon.getNome() + " adicionado ao time de " + treinador.getNome();
    }

//    @Operation(
//            summary = "Andar",
//            description = "O Treinador anda para 4 direções: Esquerda, Direita, Cima e Baixo"
//    )
//    @ApiResponses({
//            @ApiResponse(
//                    responseCode = "301",
//                    description = "Treinador andou"
//            ),
//            @ApiResponse(
//                    responseCode = "501",
//                    description = "Erro: Treinador não andou"
//            )
//    })
//    @GetMapping("/{id}/andar/{direcao}")
//    public String andar(
//            @Parameter(
//                    description = "ID do Treinador que irá andar",
//                    example = "1"
//            )
//            @PathVariable int id,
//
//            @Parameter(
//                    description = "Model do treinador",
//                    example = ""
//            )
//            @RequestBody TreinadorModel treinador,
//
//            @Parameter(
//                    description = "Direção para qual o treinador vai andar (cima, baixo, esquerda, direita)",
//                    example = "cima"
//            )
//            @PathVariable String direcao) {
//
//        for(TreinadorModel entrada : treinadores){
//            if(entrada.getId() == id){
//                treinador = entrada;
//            }
//        }
//        return treinador.getNome() + " andou para " + direcao;
//    }
//
//    @PatchMapping("/{id}/adicionarPokemonTime/{idPokemon}")
//    public String adicionarPokemonTime(@PathVariable int id, @PathVariable int idPokemon) {
//        TreinadorModel treinador = null;
//
//        for(TreinadorModel entrada : treinadores){
//            if(entrada.getId() == id){
//                treinador = entrada;
//            }
//        }
//
//        PokedexModel pokemon = null;
//
//        for(PokedexModel entrada : pokemons){
//            if(entrada.getId() == (long) idPokemon){
//                pokemon = entrada;
//            }
//        }
//
//        if (treinador == null || pokemon == null) {
//            return "Treinador ou Pokémon não encontrado na lista.";
//        }
//
//        if (treinador.temEspacoNoTime()) {
//            treinador.getTimePokemon().add(pokemon);
//            return pokemon.getNome() + " adicionado ao time de " + treinador.getNome();
//        } else {
//            return "Time cheio";
//        }
//    }

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
