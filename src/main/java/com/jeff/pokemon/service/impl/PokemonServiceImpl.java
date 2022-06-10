package com.jeff.pokemon.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jeff.pokemon.http.HttpHelper;
import com.jeff.pokemon.model.PokemonList;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.model.response.PayloadResponse;
import com.jeff.pokemon.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final Logger log = LoggerFactory.getLogger("LOGGER");
    private final String url ="https://pokeapi.co/api/v2/pokemon/?limit=9999";

    private HttpHelper http = new HttpHelper();

    @Override
    public PokemonList getPokemonsByName(String name, SortType sort) throws Exception {
        log.info(">>Starting searching pokemon by name: {}",name);
        var response = http.doGet(String.format("%s/%s",url,name));
        log.info(">api response: {}",response.statusCode());
        if(response.statusCode() == HttpStatus.OK.value()){
            var resp = new Gson().fromJson(response.body(), PayloadResponse.class);
            log.info("");
        }else{
            //TODO nao encontrado ou servico fora do ar
        }
        return null;
    }
}
