package com.jeff.pokemon.service;

import com.jeff.pokemon.model.PokemonList;
import com.jeff.pokemon.model.enums.SortType;

public interface PokemonService {
    /**
     * Get a list of pokemons by name, sorted by the given sort type.
     * 
     * @param name The any part of the pokemon name you want to search for.
     * @param sort The sort type.
     * @return A list of Pokemon names.
     */
    public PokemonList getPokemonsByName(String name, SortType sort);
}
