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

    @PostMapping
    public PokedexModel adicionarPokemon(@RequestBody PokedexModel pokemon) {
        pokemons.add(pokemon);
        return pokemon;
    }

    /**
     * Lista os Pokémons cadastrados
     * @return
     */

    @Operation(
            summary = "Lista de Pokémons",
            description = "Retorna todos os Pokémons cadastrados"
    )
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
    public PokedexModel atualizarPokemon(
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
        return pokemon;
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
    public void deletarPokemonId(
            @Parameter(
                    description = "ID do Pokémon que será removido",
                    example = "1"
            )
            @PathVariable int id){


        for(PokedexModel entrada : pokemons){
            if(entrada.getId() == id){
                pokemons.remove(entrada);
            }
        }

    }
    @Operation(
            summary = "Ataque",
            description = "O Pokémon ataca"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "220",
                    description = "Pokémon atacou com sucesso"
            ),
            @ApiResponse(
                    responseCode = "420",
                    description = "Erro: Pokémon não atacou"
            )
    })
    @GetMapping("/{id}/atacar")
    public String ataquePokemon(
            @Parameter(
                    description = "ID do Pokémon que irá atacar",
                    example = "1"
            )
            @PathVariable int id, PokedexModel pokemon){

        pokemon = null;

        for(PokedexModel entrada : pokemons){
            if(entrada.getId() == id){
                pokemon = entrada;
            }
        }

        int nivel = pokemon.getNivel();
        int ataque = pokemon.getAtaque();
        int defesa = pokemon.getDefesa();
        double nivelPorcentagem = ((2.0 * nivel) / 5.0) + 2.0;
        double danoBase = ((nivelPorcentagem * ataque * ((double) ataque / defesa)) / 50.0) + 2.0;

        return String.format("%s atacou. %f de dano",  pokemon.getNome(), danoBase);
    }

    @Operation(
            summary = "Esquivar",
            description = "O Pokémon esquiva"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "221",
                    description = "Pokémon tentou esquivar"
            ),
            @ApiResponse(
                    responseCode = "421",
                    description = "Erro: Pokémon não tentou esquivar"
            )
    })
    @GetMapping("/{id}/esquivar")
    public String esquivaPokemon(@PathVariable int id, PokedexModel pokemon) {
        Random random = new Random();
        String mensagem = null;

        pokemon = null;

        for(PokedexModel entrada : pokemons){
            if(entrada.getId() == id){
                pokemon = entrada;
            }
        }
        int numeroEsquiva = random.nextInt(100 - 1 + 1) + 1;
        if (numeroEsquiva <=50) {
            mensagem = pokemon.getNome() + " tentou esquivar...e falhou!";
        } else {
            mensagem = pokemon.getNome() + " tentou esquivar...e esquivou com sucesso!";
        }
        return mensagem;
    }

    @Operation(
            summary = "Subir de nível",
            description = "O Pokémon sobe de nível, aumentando seus status"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "222",
                    description = "Pokémon subiu de nível com sucesso"
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Erro: Pokémon não subiu de nível"
            )
    })
    @PatchMapping("/{id}/subirNivel/{nivel}")
    public String subirNivelPokemon(@PathVariable int id, PokedexModel pokemon, @PathVariable int nivel) {

        pokemon = null;

        for(PokedexModel entrada : pokemons) {
            if(entrada.getId() == id) {
                pokemon = entrada;
            }
        }

        int nivelTotal = nivel + pokemon.getNivel();
        pokemon.setNivel(nivelTotal);
        atualizarPokemon(id, pokemon);

        return pokemon.getNome() + " subiu " + nivel + " níveis! Nível atual: "+pokemon.getNivel();
    }

    @PatchMapping("/{id}/evoluir/{nome}")
    public String evoluir(@PathVariable int id, PokedexModel pokemon, @PathVariable String nome) {
        pokemon = null;

        for(PokedexModel entrada : pokemons) {
            if(entrada.getId() == id) {
                pokemon = entrada;
            }
        }

        String mensagem = null;

        if(pokemon.getNivel() >= 15){
            String nomeAntigo = pokemon.getNome();
            pokemon.setNome(nome);
            mensagem = nomeAntigo + " está evoluindo... " + nomeAntigo + " evoluiu para "+pokemon.getNome();
        }else{
            mensagem =  pokemon.getNome() + " não tem nível suficiente para evoluir!";
        }

        return mensagem;
    }

    @GetMapping("/{id}/fugir")
    public String fugirPokemon(@PathVariable int id, PokedexModel pokemon) {
        Random random = new Random();
        String mensagem = null;
        pokemon = null;

        for(PokedexModel entrada : pokemons) {
            if(entrada.getId() == id) {
                pokemon = entrada;
            }
        }

        int numeroEsquiva = random.nextInt(100 - 1 + 1) + 1;
        if (numeroEsquiva <=50) {
            mensagem = pokemon.getNome() + " tentou fugir...e falhou!";
        } else {
            mensagem = pokemon.getNome() + " tentou fugir...e fugiu com sucesso!";
        }
        return mensagem;
    }

    @PatchMapping("/{id}/desmaiar")
    public String desmaiarPokemon(@PathVariable int id, PokedexModel pokemon) {

        pokemon = null;

        for(PokedexModel entrada : pokemons) {
            if(entrada.getId() == id) {
                pokemon = entrada;
            }
        }

        pokemon.setVida(0);
        return pokemon.getNome() + " desmaiou...";
    }

    @PatchMapping("/{id}/segurarItem/{item}")
    public String segurarItemPokemon(@PathVariable int id, PokedexModel pokemon, @PathVariable String item) {

        pokemon = null;

        for(PokedexModel entrada : pokemons) {
            if(entrada.getId() == id) {
                pokemon = entrada;
            }
        }

        pokemon.setItem(item);
        return pokemon.getNome() + " está segurando o item " + pokemon.getItem();
    }

    @PatchMapping("/{id}/usarItem/{vida}")
    public String usarItemPokemon(@PathVariable int id, PokedexModel pokemon,  @PathVariable Integer vida) {
        pokemon = null;

        for(PokedexModel entrada : pokemons) {
            if(entrada.getId() == id) {
                pokemon = entrada;
            }
        }

        String mensagem = null;

        if(pokemon.getVidaMaxima() >= (vida+ pokemon.getVida())) {
            pokemon.setVida(pokemon.getVida() + vida);
            mensagem = pokemon.getNome() + " usou " + pokemon.getItem() + " e recuperou " + vida + " de vida";
            pokemon.setItem(null);
        }else{

            mensagem = "Erro, pokémon já está com a vida máxima";
        }
        return mensagem;
    }
}
