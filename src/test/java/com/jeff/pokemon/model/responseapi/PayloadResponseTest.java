package com.jeff.pokemon.model.responseapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jeff.pokemon.model.ResponsePay;

public class PayloadResponseTest {
    
    private  PayloadResponse response;

    private ArrayList list;

    @BeforeEach
    public void init(){
        response = new PayloadResponse();
        list = new ArrayList<>();
        response.setCount(123);
        response.setResults(list);
        
    }

    @Test
    public void getResultsTest(){
        assertEquals(list, response.getResults());
    }
    @Test
    public void getCountTest(){
        assertEquals(123, response.getCount());
    }
}
