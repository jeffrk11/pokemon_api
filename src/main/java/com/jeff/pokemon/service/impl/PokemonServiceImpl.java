package com.jeff.pokemon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jeff.pokemon.exceptions.TechnicalException;
import com.jeff.pokemon.model.Pokemon;
import com.jeff.pokemon.model.PokemonList;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.PokeApiService;
import com.jeff.pokemon.service.PokemonService;
import com.jeff.pokemon.utils.PokemonSortUtils;

@Service

public class PokemonServiceImpl implements PokemonService {

    private final Logger log = LoggerFactory.getLogger("LOGGER");
    private PokeApiService pokeApi = new PokeApiServiceImpl();

    
    @Override
    public PokemonList sortPokemonByName(String name, SortType sort) {
        List<Pokemon> pokemons = findPokemonsByName(name);
        List<String> names = this.sortPokemonsNames(pokemons, sort);
        return new PokemonList<>(names);
    }
    
    @Override
    public PokemonList sortPokemonByNameHighlight(String name, SortType sort) {
        List<Pokemon> pokemons = this.findPokemonsByName(name);
        
        return null;
    }
    @Override
    public List<Pokemon> getPokemons(){
        List<Pokemon> pokemons = pokeApi.getAllPokemons();
        
        if(pokemons.size() == 0)
            throw new TechnicalException("Unexpected response when requesting pokeApi");
        
        return pokemons;
    }

    private List<Pokemon> findPokemonsByName(String name){
        List<Pokemon> names = new ArrayList<>();
        
        for(Pokemon pokemon : this.getPokemons()){
            if(pokemon.getName().contains(name))
                names.add(new Pokemon(pokemon.getName()));
        }
        return names;
    }

    private List<String> sortPokemonsNames(List<Pokemon> pokemons, SortType sort){
        List<String> names = new ArrayList<>(pokemons.stream()
                                                        .map(p -> p.getName())
                                                        .collect(Collectors.toList()));
        if(sort == SortType.LENGTH)
            names = PokemonSortUtils.lenghtSort(names);
        else    
            names = PokemonSortUtils.alphabeticalSort(names);
        
        return names;
    }



    
}
