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
import com.jeff.pokemon.service.ValidationRequestService;
import com.jeff.pokemon.service.impl.PokemonServiceImpl;
import com.jeff.pokemon.service.impl.ValidationRequestServiceImpl;

@RestController
public class PokemonController {
    
    private PokemonService service = new PokemonServiceImpl();
    private ValidationRequestService validation = new ValidationRequestServiceImpl();

    @GetMapping("/pokemon")
    public ResponseEntity<?> findPokemons(@RequestParam String query, @RequestParam(required = false) SortType sort) throws Exception{
        validation.validationRequest(query, sort);
        return new ResponseEntity<>(service.sortPokemonByName(query,sort),HttpStatus.OK);
    }

    @GetMapping("/pokemon/highlight")
    public ResponseEntity<?> findPokemonsHighlight(@RequestParam String query, @RequestParam(required = false) SortType sort) throws Exception{
        validation.validationRequest(query, sort);
        return new ResponseEntity<>(service.sortPokemonByNameHighlight(query,sort),HttpStatus.OK);
    }
}
