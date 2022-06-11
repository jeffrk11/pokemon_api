package com.jeff.pokemon.service;

import java.util.List;

import com.jeff.pokemon.model.PokemonList;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.model.response.PokemonName;

public interface PokemonService {

    /**
     * Get a list of all the Pokemon names.
     * 
     * @return A list of PokemonNames
     */
    public List<PokemonName> getPokemons();


    /**
     * Sort the PokemonList by name, and return the sorted list.
     * 
     * @param name Any name part of the Pokemon you want to search for.
     * @param sort The type of sort you want to do.
     * @return A PokemonList object
     */
    public PokemonList sortPokemonByName(String name, SortType sort);
}
