package com.jeff.pokemon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jeff.pokemon.exceptions.TechnicalException;
import com.jeff.pokemon.http.HttpHelper;
import com.jeff.pokemon.model.PokemonList;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.model.response.PayloadResponse;
import com.jeff.pokemon.model.response.PokemonName;
import com.jeff.pokemon.service.PokeApiService;
import com.jeff.pokemon.service.PokemonService;
import com.jeff.pokemon.utils.PokemonSortUtils;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final Logger log = LoggerFactory.getLogger("LOGGER");
    private PokeApiService pokeApi = new PokeApiServiceImpl();

    @Override
    public List<PokemonName> getPokemons(){
        var pokemons = pokeApi.getAllPokemons();
        
        if(pokemons.size() == 0)
            throw new TechnicalException("Unexpected response when requesting pokeApi");
        
        return pokeApi.getAllPokemons();
    }

    @Override
    public PokemonList sortPokemonByName(String name, SortType sort) {
        List<PokemonName> pokemons = this.getPokemons();
        List<String> names = new  ArrayList<>();
        
        for(var pokemon : pokemons){
            if(pokemon.getName().contains(name))
                names.add(pokemon.getName());
        }

        if(sort == SortType.LENGTH)
            return PokemonSortUtils.lenghtSort(names);
        else    
            return PokemonSortUtils.alphabeticalSort(names);
    }

    
}
