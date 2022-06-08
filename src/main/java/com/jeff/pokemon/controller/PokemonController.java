package com.jeff.pokemon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    
    @GetMapping("/pokemon")
    public ResponseEntity<?> findPokemon(){

        return new ResponseEntity<>("OLA",HttpStatus.OK);
    }
}
