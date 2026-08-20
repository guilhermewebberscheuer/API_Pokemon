package com.api.API_Pokedex.service;

import com.api.API_Pokedex.controller.PokedexController;
import com.api.API_Pokedex.model.PokedexModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/v1/pokemons/action")
@Service
public class PokedexService {
    private final List<PokedexModel> pokemons = new ArrayList<>();

    public String adicionarPokemon(PokedexModel pokemon) {

        pokemons.add(pokemon);

        return pokemon.getNome() + "foi cadastrado com sucesso!";
    }

    public List<PokedexModel> listarPokemons() {
        return pokemons;
    }

    public PokedexModel buscarPokemonPorId(Long id) {

        for (PokedexModel pokemon : pokemons) {
            if (pokemon.getId().equals(id)) {
                return pokemon;
            }
        }
        return null;
    }

    public String atualizarPokemon(Long id, PokedexModel pokemon) {

        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getId().equals(id)) {
                pokemons.set(i, pokemon);
                return pokemon.getNome() + " foi atualizado com sucesso!";
            }
        }
        return "Pokémon não encontrado";
    }

    public String deletarPokemon(Long id) {
        PokedexModel pokemon = buscarPokemonPorId(id);

        if (pokemon == null) {
            return "Pokémon não encontrado";
        }
        pokemons.remove(pokemon);

        return "Pokémon deletado com sucesso!";
    }

    //@Operation(
    //        summary = "Ataque",
    //        description = "O Pokémon ataca"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "220",
    //                description = "Pokémon atacou com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "420",
    //                description = "Erro: Pokémon não atacou"
    //        )
    //})
    //@GetMapping("/{id}/atacar")
    //public String ataquePokemon(
    //        @Parameter(
    //                description = "ID do Pokémon que irá atacar",
    //                example = "1"
    //        )
    //        @PathVariable int id,
//
    //        @Parameter(
    //                description = "Model do Pokémon daonde será pego o ataque, nível, defesa e nome",
    //                example = ""
    //        )
    //        PokedexModel pokemon){
//
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons){
    //        if(entrada.getId() == id){
    //            pokemon = entrada;
    //        }
    //    }
//
    //    int nivel = pokemon.getNivel();
    //    int ataque = pokemon.getAtaque();
    //    int defesa = pokemon.getDefesa();
    //    double nivelPorcentagem = ((2.0 * nivel) / 5.0) + 2.0;
    //    double danoBase = ((nivelPorcentagem * ataque * ((double) ataque / defesa)) / 50.0) + 2.0;
//
    //    return String.format("%s atacou. %f de dano",  pokemon.getNome(), danoBase);
    //}
//
    //@Operation(
    //        summary = "Esquivar",
    //        description = "O Pokémon esquiva"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "221",
    //                description = "Pokémon tentou esquivar"
    //        ),
    //        @ApiResponse(
    //                responseCode = "421",
    //                description = "Erro: Pokémon não tentou esquivar"
    //        )
    //})
    //@GetMapping("/{id}/esquivar")
    //public String esquivaPokemon(
    //        @Parameter(
    //                description = "ID do Pokémon que irá esquivar",
    //                example = "1"
    //        )
    //        @PathVariable int id,
//
    //        @Parameter(
    //                description = "Model do Pokémon",
    //                example = ""
    //        )
    //        PokedexModel pokemon) {
    //    Random random = new Random();
    //    String mensagem = null;
//
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons){
    //        if(entrada.getId() == id){
    //            pokemon = entrada;
    //        }
    //    }
    //    int numeroEsquiva = random.nextInt(100 - 1 + 1) + 1;
    //    if (numeroEsquiva <=50) {
    //        mensagem = pokemon.getNome() + " tentou esquivar...e falhou!";
    //    } else {
    //        mensagem = pokemon.getNome() + " tentou esquivar...e esquivou com sucesso!";
    //    }
    //    return mensagem;
    //}
//
    //@Operation(
    //        summary = "Subir de nível",
    //        description = "O Pokémon sobe de nível, aumentando seus status"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "222",
    //                description = "Pokémon subiu de nível com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "422",
    //                description = "Erro: Pokémon não subiu de nível"
    //        )
    //})
    //@PatchMapping("/{id}/subirNivel/{nivel}")
    //public String subirNivelPokemon(
    //        @Parameter(
    //                description = "ID do Pokémon que irá subir de nível",
    //                example = "1"
    //        )
    //        @PathVariable int id,
//
    //        @Parameter(
    //                description = "Model do Pokémon",
    //                example = ""
    //        )
    //        PokedexModel pokemon,
//
    //        @Parameter(
    //                description = "Quantidades de níveis a mais que o Pokémon terá",
    //                example = "2"
    //        )
    //        @PathVariable int nivel) {
//
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons) {
    //        if(entrada.getId() == id) {
    //            pokemon = entrada;
    //        }
    //    }
//
    //    int nivelTotal = nivel + pokemon.getNivel();
    //    pokemon.setNivel(nivelTotal);
    //    pokedex.atualizarPokemon(id, pokemon);
//
    //    return pokemon.getNome() + " subiu " + nivel + " níveis! Nível atual: "+pokemon.getNivel();
    //}
//
    //@Operation(
    //        summary = "Evoluir",
    //        description = "O Pokémon evolui, mudando seu nome e aparência"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "223",
    //                description = "Pokémon evoluiu com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "423",
    //                description = "Erro: Pokémon não evoluiu"
    //        )
    //})
    //@PatchMapping("/{id}/evoluir/{nome}")
    //public String evoluir(
    //        @Parameter(
    //                description = "ID do Pokémon que irá evoluir",
    //                example = "1"
    //        )
    //        @PathVariable int id,
//
    //        @Parameter(
    //                description = "Model do Pokémon",
    //                example = ""
    //        )
    //        PokedexModel pokemon,
//
    //        @Parameter(
    //                description = "Novo nome do Pokémon",
    //                example = "Raichu"
    //        )
    //        @PathVariable String nome) {
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons) {
    //        if(entrada.getId() == id) {
    //            pokemon = entrada;
    //        }
    //    }
//
    //    String mensagem = null;
//
    //    if(pokemon.getNivel() >= 15){
    //        String nomeAntigo = pokemon.getNome();
    //        pokemon.setNome(nome);
    //        mensagem = nomeAntigo + " está evoluindo... " + nomeAntigo + " evoluiu para "+pokemon.getNome();
    //    }else{
    //        mensagem =  pokemon.getNome() + " não tem nível suficiente para evoluir!";
    //    }
//
    //    return mensagem;
    //}
//
    //@Operation(
    //        summary = "Fugir",
    //        description = "O Pokémon foge, escapando da batalha"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "224",
    //                description = "Pokémon fugiu com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "424",
    //                description = "Erro: Pokémon não fugiu"
    //        )
    //})
    //@GetMapping("/{id}/fugir")
    //public String fugirPokemon(
    //        @Parameter(
    //                description = "ID do Pokémon que irá fugir",
    //                example = "1"
    //        )
    //        @PathVariable int id,
//
    //        @Parameter(
    //                description = "Model do Pokémon",
    //                example = ""
    //        )
    //        PokedexModel pokemon) {
    //    Random random = new Random();
    //    String mensagem = null;
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons) {
    //        if(entrada.getId() == id) {
    //            pokemon = entrada;
    //        }
    //    }
//
    //    int numeroEsquiva = random.nextInt(100 - 1 + 1) + 1;
    //    if (numeroEsquiva <=50) {
    //        mensagem = pokemon.getNome() + " tentou fugir...e falhou!";
    //    } else {
    //        mensagem = pokemon.getNome() + " tentou fugir...e fugiu com sucesso!";
    //    }
    //    return mensagem;
    //}
//
//
    //@Operation(
    //        summary = "Desmaiar",
    //        description = "O Pokémon desmaia, não podendo mais batalhar"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "225",
    //                description = "Pokémon desmaiou com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "425",
    //                description = "Erro: Pokémon não desmaiou"
    //        )
    //})
    //@PatchMapping("/{id}/desmaiar")
    //public String desmaiarPokemon(
    //        @Parameter(
    //                description = "ID do Pokémon que irá desmaiar",
    //                example = "1"
    //        )
    //        @PathVariable int id,
//
    //        @Parameter(
    //                description = "Model do Pokémon",
    //                example = ""
    //        )
    //        PokedexModel pokemon) {
//
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons) {
    //        if(entrada.getId() == id) {
    //            pokemon = entrada;
    //        }
    //    }
//
    //    pokemon.setVida(0);
    //    return pokemon.getNome() + " desmaiou...";
    //}
//
//
    //@Operation(
    //        summary = "Segurar Item",
    //        description = "O Pokémon segura um item, podendo usá-lo no meio da batalha"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "226",
    //                description = "Pokémon segurou o item com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "426",
    //                description = "Erro: Pokémon não segurou o item"
    //        )
    //})
    //@PatchMapping("/{id}/segurarItem/{item}")
    //public String segurarItemPokemon(
    //        @Parameter(
    //                description = "ID do Pokémon que irá segurar o item",
    //                example = "1"
    //        )
    //        @PathVariable int id,
//
    //        @Parameter(
    //                description = "Model do Pokémon",
    //                example = ""
    //        )
    //        PokedexModel pokemon,
//
    //        @Parameter(
    //                description = "Nome do item",
    //                example = "Fruta Oran"
    //        )
    //        @PathVariable String item) {
//
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons) {
    //        if(entrada.getId() == id) {
    //            pokemon = entrada;
    //        }
    //    }
//
    //    pokemon.setItem(item);
    //    return pokemon.getNome() + " está segurando o item " + pokemon.getItem();
    //}
//
//
    //@Operation(
    //        summary = "Usar Item",
    //        description = "O Pokémon usa o item que está segurando, aumentando seus status"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "227",
    //                description = "Pokémon usou item com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "427",
    //                description = "Erro: Pokémon não usou item"
    //        )
    //})
    //@PatchMapping("/{id}/usarItem/{vida}")
    //public String usarItemPokemon(
    //        @Parameter(
    //                description = "ID do Pokémon que irá usar o item",
    //                example = ""
    //        )
    //        @PathVariable int id,
//
    //        @Parameter(
    //                description = "Model do Pokémon",
    //                example = ""
    //        )
    //        PokedexModel pokemon,
//
    //        @Parameter(
    //                description = "Nova vida do Pokémon",
    //                example = ""
    //        )
    //        @PathVariable Integer vida) {
    //    pokemon = null;
//
    //    for(PokedexModel entrada : pokemons) {
    //        if(entrada.getId() == id) {
    //            pokemon = entrada;
    //        }
    //    }
//
    //    String mensagem = null;
//
    //    if(pokemon.getVidaMaxima() >= (vida+ pokemon.getVida())) {
    //        pokemon.setVida(pokemon.getVida() + vida);
    //        mensagem = pokemon.getNome() + " usou " + pokemon.getItem() + " e recuperou " + vida + " de vida";
    //        pokemon.setItem(null);
    //    }else{
//
    //        mensagem = "Erro, pokémon já está com a vida máxima";
    //    }
    //    return mensagem;
    //}
}
