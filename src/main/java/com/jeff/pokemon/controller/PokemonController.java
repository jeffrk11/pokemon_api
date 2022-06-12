package com.jeff.pokemon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger log = LoggerFactory.getLogger("LOGGER");
    private PokemonService service = new PokemonServiceImpl();
    private ValidationRequestService validation = new ValidationRequestServiceImpl();

    @GetMapping("/pokemon")
    public ResponseEntity<?> findPokemons(@RequestParam String query, @RequestParam(required = false) SortType sort) throws Exception{
        log.info("Start process find pokemon");
        query = validation.validationName(query);
        sort = validation.validationSortType(sort);
        return new ResponseEntity<>(service.findPokemonByName(query,sort),HttpStatus.OK);
    }

    @GetMapping("/pokemon/highlight")
    public ResponseEntity<?> findPokemonsHighlight(@RequestParam String query, @RequestParam(required = false) SortType sort) throws Exception{
        log.info("Start process find pokemon with highlight");
        query = validation.validationName(query);
        sort = validation.validationSortType(sort);
        return new ResponseEntity<>(service.findPokemonByNameHighlight(query,sort),HttpStatus.OK);
    }
}
