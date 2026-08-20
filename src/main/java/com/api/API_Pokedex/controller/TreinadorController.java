package com.api.API_Pokedex.controller;

import com.api.API_Pokedex.model.GinasioModel;
import com.api.API_Pokedex.model.TreinadorModel;
import com.api.API_Pokedex.service.TreinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/treinadores")
public class TreinadorController {

    private final TreinadorService treinadorService;

    public TreinadorController(TreinadorService treinadorService) {
        this.treinadorService = treinadorService;
    }

    @PostMapping
    public String adicionarTreinador(
            @RequestBody TreinadorModel treinador) {

        return treinadorService.adicionarTreinador(treinador);
    }

    @GetMapping
    public List<TreinadorModel> listarTreinadores() {

        return treinadorService.listarTreinadores();
    }

    @GetMapping("/{id}")
    public TreinadorModel buscarTreinadorPorId(
            @PathVariable Integer id) {

        return treinadorService.buscarTreinadorPorId(id);
    }

    @PutMapping("/{id}")
    public String atualizarTreinador(
            @PathVariable Integer id,
            @RequestBody TreinadorModel treinador){

        return treinadorService.atualizarTreinador(id, treinador);
    }

    @DeleteMapping("/{id}")
    public String deletarTreinadorId(
            @PathVariable Integer id){

        return treinadorService.deletarTreinador(id);
    }

    @PatchMapping("/actions/{id}/adicionarPokemonTime/{idPokemon}")
    public String adicionarPokemonTime(
            @PathVariable Integer id,
            @PathVariable Long idPokemon) {
        return treinadorService.adicionarPokemonTime(
                id,
                idPokemon
        );
    }

    //private final List<TreinadorModel> treinadores = new ArrayList<>();
//
//
    //@Operation(
    //        summary = "Adicionar treinador",
    //        description = "Um treinador será adicionado à lista 'treinadores'"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "271",
    //                description = "Treinador adicionado com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "471",
    //                description = "Erro: Treinador não adicionado"
    //        )
    //})
    //@PostMapping
    //public String adicionarTreinador(@RequestBody TreinadorModel treinador) {
    //    treinadores.add(treinador);
    //    return treinador.getNome() + " cadastrado com sucesso";
    //}
//
//
    //@Operation(
    //        summary = "Listar treinadores",
    //        description = "Os treinadores serão listados"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "272",
    //                description = "Treinadores foram listados"
    //        ),
    //        @ApiResponse(
    //                responseCode = "472",
    //                description = "Erro: Treinadores não foram listados"
    //        )
    //})
    //@GetMapping
    //public List<TreinadorModel> listarTreinadores() {
    //    return treinadores;
    //}
//
//
    //@Operation(
    //        summary = "Buscar Treinador por ID",
    //        description = "O treinador será selecionado pelo ID do treinador"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "273",
    //                description = "Treinador encontrado"
    //        ),
    //        @ApiResponse(
    //                responseCode = "473",
    //                description = "Erro: Treinador não encontrado"
    //        )
    //})
    //@GetMapping("/{id}")
    //public TreinadorModel buscarTreinadorId(@PathVariable int id){
    //    TreinadorModel treinador = null;
//
    //    for(TreinadorModel entrada : treinadores){
    //        if(entrada.getId() == id){
    //            treinador = entrada;
    //        }
    //    }
//
    //    return treinador;
    //}
//
//
    //@Operation(
    //        summary = "Atualizar Treinador",
    //        description = "O treinador será atualizado"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "274",
    //                description = "Treinador atualizado com sucesso"
    //        ),
    //        @ApiResponse(
    //                responseCode = "474",
    //                description = "Erro: Treinador não atualizado"
    //        )
    //})
    //@PutMapping("/{id}")
    //public String atualizarTreinador(
    //        @Parameter(
    //                description = "ID do Treinador que será atualizado",
    //                example = "1"
    //        )
    //        @PathVariable int id, @RequestBody TreinadorModel treinador) {
    //    int index = 0;
//
    //    for(TreinadorModel entrada : treinadores){
    //        if(entrada.getId() == id){
    //            index = treinadores.indexOf(entrada);
    //        }
    //    }
//
    //    TreinadorModel set = treinadores.set(index, treinador);
    //    return treinador.getNome() + " atualizado com sucesso";
    //}
//
//
    //@Operation(
    //        summary = "Deletar treinador",
    //        description = "O treinador será deletado"
    //)
    //@ApiResponses({
    //        @ApiResponse(
    //                responseCode = "275",
    //                description = "Treinador deletado"
    //        ),
    //        @ApiResponse(
    //                responseCode = "475",
    //                description = "Erro: Treinador não deletado"
    //        )
    //})
    //@DeleteMapping("/{id}")
    //public String deletarTreinadorId(
    //        @Parameter(
    //                description = "ID do Treinador que será removido",
    //                example = "1"
    //        )
    //        @PathVariable int id){
//
//
    //    for(TreinadorModel entrada : treinadores){
    //        if(entrada.getId() == id){
    //            treinadores.remove(entrada);
    //        }
    //    }
//
    //    return "Treinador deletado com sucesso";
    //}
}
