package com.jeff.pokemon.service;

import java.util.List;

import com.jeff.pokemon.model.Pokemon;
import com.jeff.pokemon.model.PokemonList;
import com.jeff.pokemon.model.enums.SortType;

public interface PokemonService {

    /**
     * Get a list of all the Pokemon names.
     * 
     * @return A list of PokemonNames
     */
    public List<Pokemon> getPokemons();


    /**
     * Sort the PokemonList by name, and return the sorted list.
     * 
     * @param name Any name part of the Pokemon you want to search for.
     * @param sort The type of sort you want to do.
     * @return A PokemonList object
     */
    public PokemonList sortPokemonByName(String name, SortType sort);

    /**
     * Sort the Pokemon by name, and highlight the Pokemon with the given name.
     * 
     * @param name The name of the pokemon you want to search for.
     * @param sort The type of sort you want to do.
     * @return A highlighted PokemonList object.
     */
    public PokemonList sortPokemonByNameHighlight(String name, SortType sort);
}
