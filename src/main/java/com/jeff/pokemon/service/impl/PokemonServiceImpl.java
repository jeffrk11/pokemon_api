package com.jeff.pokemon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jeff.pokemon.exceptions.TechnicalException;
import com.jeff.pokemon.model.Pokemon;
import com.jeff.pokemon.model.ResponsePay;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.PokeApiService;
import com.jeff.pokemon.service.PokemonService;
import com.jeff.pokemon.utils.PokemonSortUtils;

public class PokemonServiceImpl implements PokemonService {

    private final Logger log = LoggerFactory.getLogger("LOGGER");
    private PokeApiService pokeApi = new PokeApiServiceImpl();

    
    @Override
    public ResponsePay<String> findPokemonByName(String name, SortType sort) {
        log.info(">>Starting finding pokemon with name '{}' using sort type '{}'",name,sort);
        List<Pokemon> pokemons = this.getPokemons(name);
        List<String> names = this.sortPokemonsNames(pokemons, sort);

        return new ResponsePay<>(names);
    }
    
    @Override
    public ResponsePay<Pokemon> findPokemonByNameHighlight(String name, SortType sort) {
        log.info(">>Starting finding pokemon hifh light with name '{}' using sort type '{}'",name,sort);
        List<Pokemon> pokemons = this.getPokemons(name);
        List<String> names = this.sortPokemonsNames(pokemons, sort);

        return new ResponsePay<>( names.stream()
                                            .map(n -> new Pokemon(n,n.replace(name, "<pre>"+name+"</pre>")))
                                            .collect(Collectors.toList()));
    }
    
    @Override
    public List<Pokemon> getPokemons(String name){
        List<Pokemon> pokemons = pokeApi.getAllPokemons();
            
        if(pokemons.size() == 0)
            throw new TechnicalException("Unexpected response when requesting pokeApi");
        
        List<Pokemon> response = new ArrayList<>();
        if(name != null){
            for(Pokemon pokemon : pokeApi.getAllPokemons()){
                if(pokemon.getName().contains(name))
                    response.add(pokemon);
            }
        }
        return response;
    }

    private List<String> sortPokemonsNames(List<Pokemon> pokemons, SortType sort){
        List<String> names = new ArrayList<>(pokemons.stream()
                                                        .map(p -> p.getName())
                                                        .collect(Collectors.toList()));   
        return PokemonSortUtils.sort(names,sort);
    }



    
}
