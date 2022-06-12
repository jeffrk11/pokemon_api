package com.jeff.pokemon.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.jeff.pokemon.exceptions.TechnicalException;
import com.jeff.pokemon.http.HttpHelper;
import com.jeff.pokemon.model.Pokemon;
import com.jeff.pokemon.model.response.PayloadResponse;
import com.jeff.pokemon.service.PokeApiService;


public class PokeApiServiceImpl implements PokeApiService{

    private final Logger log = LoggerFactory.getLogger("LOGGER");
    private final String url ="https://pokeapi.co/api/v2/pokemon/?limit=9999"; //api url
    private final int caching_time = 1800; //30 minutes
    
    private LocalDateTime time;
    private PayloadResponse payloadResp;

    private HttpHelper http = new HttpHelper();

    public PokeApiServiceImpl(){
        //caching this way, without autowired
        log.info(">>Caching pokemons..");
        this.updatePayload();
    }


    @Override
    public List<Pokemon> getAllPokemons() {
        log.info(">>Starting calling pokemon api");
        if(Duration.between(time,LocalDateTime.now()).getSeconds() >= caching_time )
            this.updatePayload();
        
       return Collections.unmodifiableList(payloadResp.getResults());
    }

    private void updatePayload(){
        log.info(">>Calling PokeApi..");
        time = LocalDateTime.now();
        try {
            var response = http.doGet(url);
            log.info(">api response: {}",response.statusCode());
            if(response.statusCode() == HttpStatus.OK.value()){
                payloadResp = new Gson().fromJson(response.body(), PayloadResponse.class);
            }else{
                log.info(">>Unexpected response, using cache");
            }
        } catch (Exception e) {
            log.info(">>Something wrong calling the pokeApi");
            throw new TechnicalException("PokeApi unavailable");
        }
    }
    
}
