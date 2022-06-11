package com.jeff.pokemon.service;

import java.util.List;

import com.jeff.pokemon.model.response.PokemonName;

public interface PokeApiService {
    
    /**
     * Get a list of all the Pokemon names.
     * 
     * @return A list of PokemonNames
     */
    public List<PokemonName> getAllPokemons();
}
