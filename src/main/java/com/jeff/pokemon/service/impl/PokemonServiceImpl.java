package com.jeff.pokemon.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.jeff.pokemon.model.PokemonList;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.PokemonService;

public class PokemonServiceImpl implements PokemonService {
    
    @Value("app.params.poke-api")
    private String url;

    @Override
    public PokemonList getPokemonsByName(String name, SortType sort) {
        // TODO Auto-generated method stub
        return null;
    }
}
