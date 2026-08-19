package com.api.API_Pokedex.controller;

import com.api.API_Pokedex.model.PokedexModel;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.math.*;

/**
 * API Pokedex
 *
 * author Webber e Gian
 *
 * since 26
 */

@Tag(
    name = "Pokemons",
    description = "Lista e endpoints para cadastrar, buscar, atualizar e deletar Pokémons"
)

/**
 * Controller responsável pelos endpoints relacionados aos Pokémons
 *
 * <p>Esta classe disponibiliza operações HTTP para listar, consultar, cadastrar,
 * atualizar e remover Pokémons</p>
 *
 * <p>Os dados são mantidos em memória apenas para fins didáticos</p>
 *
 * @author Webber e Gian
 * @version 1.0
 */
@RestController
@RequestMapping("/v1/pokemons")

public class PokedexController {
    private final List<PokedexModel> pokemons = new ArrayList<>();


    @Operation(
            summary = "Adicionar Pokémon",
            description = "Um Pokémon é adicionado à lista"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "199",
                    description = "Pokémon adicionado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "499",
                    description = "Erro: Pokémon não foi adicionado"
            )
    })
    @PostMapping
    public String adicionarPokemon(@RequestBody PokedexModel pokemon) {
        pokemons.add(pokemon);
        return pokemon.getNome() + " foi cadastrado com sucesso";
    }

    /**
     * Lista os Pokémons cadastrados
     * @return
     */

    @Operation(
            summary = "Lista de Pokémons",
            description = "Retorna todos os Pokémons cadastrados"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Lista de Pokémons apresentada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Erro: Lista de Pokémon não foi apresentada"
            )
    })
    @GetMapping
    public List<PokedexModel> listarPokemon(){
        return pokemons;
    }

    @GetMapping("/{id}")
    public PokedexModel buscarPokemonId(@PathVariable int id){
        PokedexModel pokemon = null;

        for(PokedexModel entrada : pokemons){
            if(entrada.getId() == id){
                pokemon = entrada;
            }
        }

        return pokemon;
    }

    @Operation(
            summary = "Atualizar",
            description = "Atualiza um Pokémon"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pokémon encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    @PutMapping ("/{id}")
    public String atualizarPokemon(
            @Parameter(
                    description = "ID do Pokémon que será atualizado",
                    example = "1"
            )
            @PathVariable int id, @RequestBody PokedexModel pokemon){
        int index = 0;

        for(PokedexModel entrada : pokemons){
            if(entrada.getId() == id){
                index = pokemons.indexOf(entrada);
            }
        }

        PokedexModel set = pokemons.set(index, pokemon);
        return pokemon.getNome() + " foi atualizado com sucesso";
    }

    @Operation(
            summary = "Remove um Pokémon",
            description = "Remove um Pokémon utilizado seu identificador (ID)"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Pokémon removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "309",
                    description = "Pokémon não encontrado"
            )
    })
    @DeleteMapping("/{id}")
    public String deletarPokemonId(
            @Parameter(
                    description = "ID do Pokémon que será removido",
                    example = "1"
            )
            @PathVariable int id){

        String mensagem = "Erro";

        for(PokedexModel entrada : pokemons){
            if(entrada.getId() == id){
                pokemons.remove(entrada);
                mensagem = "Pokemon deletado com sucesso";
            }
        }
        return mensagem;
    }
}
