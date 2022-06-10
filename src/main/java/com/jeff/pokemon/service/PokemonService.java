package com.jeff.pokemon.service;

import java.util.List;

import com.jeff.pokemon.model.response.PokemonName;

public interface PokemonService {
    
    public List<PokemonName> getPokemons() throws Exception;
}
