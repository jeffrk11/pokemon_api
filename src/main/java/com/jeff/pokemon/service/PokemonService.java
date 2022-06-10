package com.jeff.pokemon.service;

import java.util.List;

import com.jeff.pokemon.model.PokemonList;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.model.response.PokemonName;

public interface PokemonService {
    /**
     * Get a list of pokemons by name, sorted by the given sort type.
     * 
     * @param name The any part of the pokemon name you want to search for.
     * @param sort The sort type.
     * @return A list of Pokemon names.
     * @throws Exception
     */
    public List<PokemonName> getPokemonsByName(String name, SortType sort) throws Exception;
}
