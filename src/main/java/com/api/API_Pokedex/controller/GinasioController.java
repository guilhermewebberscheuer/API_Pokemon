package com.api.API_Pokedex.controller;

import com.api.API_Pokedex.model.GinasioModel;
import com.api.API_Pokedex.model.PokedexModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ginasios")
public class GinasioController {
    private final List<GinasioModel> ginasios = new ArrayList<>();

    @Operation(
            summary = "Adicionar Ginásio",
            description = "Um Ginásio é adicionado à lista 'ginasios'"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "250",
                    description = "Ginásio adicionado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "450",
                    description = "Erro: Ginásio não foi adicionado"
            )
    })
    @PostMapping
    public String adicionarGinasio(
            @Parameter(
                    description = "Ginásio que será adicionado",
                    example = "Lumiose"
            )
            @RequestBody GinasioModel ginasio) {
        ginasios.add(ginasio);
        return ginasio.getNome() + " foi criado com sucesso";
    }


    @Operation(
            summary = "Listar ginásios",
            description = "Os ginásios serão listados"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "251",
                    description = "Ginásios foram listados"
            ),
            @ApiResponse(
                    responseCode = "451",
                    description = "Erro: Ginásios não foram listados"
            )
    })
    @GetMapping
    public List<GinasioModel> listarGinasio(){
        return ginasios;
    }


    @Operation(
            summary = "Buscar Ginásio por ID",
            description = "O ginásio será selecionado pelo ID do ginásio"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "251",
                    description = "Ginásio encontrado"
            ),
            @ApiResponse(
                    responseCode = "451",
                    description = "Erro: Ginásio não encontrado"
            )
    })
    @GetMapping("/{id}")
    public GinasioModel buscarGinasioId(
            @Parameter(
                    description = ""
            )
            @PathVariable int id){
        GinasioModel ginasio = null;

        for(GinasioModel entrada : ginasios){
            if(entrada.getId() == id){
                ginasio = entrada;
            }
        }

        return ginasio;
    }


    @Operation(
            summary = "Atualizar Ginásio",
            description = "O ginásio será atualizado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "252",
                    description = "Ginásio atualizado"
            ),
            @ApiResponse(
                    responseCode = "452",
                    description = "Erro: Ginásio não atualizado"
            )
    })
    @PutMapping ("/{id}")
    public String atualizarGinasio(
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
        return ginasio.getNome() + " foi atualizado com sucesso";
    }


    @Operation(
            summary = "Deletar ginásio",
            description = "O ginásio será deletado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "253",
                    description = "Ginásio deletado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "453",
                    description = "Erro: Ginásio não deletado"
            )
    })
    @DeleteMapping("/{id}")
    public String deletarGinasioId(
            @Parameter(
                    description = "ID do Ginásio que será deletado",
                    example = "1"
            )
            @PathVariable int id){


        for(GinasioModel entrada : ginasios){
            if(entrada.getId() == id){
                ginasios.remove(entrada);
            }
        }

        return "Ginásio deletado com sucesso";
    }
}
