package com.jeff.pokemon.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.PokemonService;
import com.jeff.pokemon.service.impl.PokemonServiceImpl;

@RestController
public class PokemonController {
    
    private PokemonService service = new PokemonServiceImpl();

    @GetMapping("/pokemon")
    public ResponseEntity<?> findPokemon(@RequestParam String query, @RequestParam(required = false) SortType sort) throws Exception{
        return new ResponseEntity<>(service.getPokemons(),HttpStatus.OK);
    }
}
