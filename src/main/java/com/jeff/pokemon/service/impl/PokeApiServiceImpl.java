package com.jeff.pokemon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.jeff.pokemon.http.HttpHelper;
import com.jeff.pokemon.model.response.PayloadResponse;
import com.jeff.pokemon.model.response.PokemonName;
import com.jeff.pokemon.service.PokeApiService;

public class PokeApiServiceImpl implements PokeApiService{

    private final Logger log = LoggerFactory.getLogger("LOGGER");
    private final String url ="https://pokeapi.co/api/v2/pokemon/?limit=9999";

    private HttpHelper http = new HttpHelper();


    @Override
    public List<PokemonName> getAllPokemons() {
        log.info(">>Starting calling pokemon api");
        try {
            var response = http.doGet(url);
            log.info(">api response: {}",response.statusCode());
            if(response.statusCode() == HttpStatus.OK.value()){
                
                var resp = new Gson().fromJson(response.body(), PayloadResponse.class);
                return resp.getResults();
            }else{

                log.info(">>Unexpected response");
                return new ArrayList<>();
            }
        } catch (Exception e) {
            log.info(">>Something wrong calling the pokeApi");
            return new ArrayList<>();
        }
    }
    
}
