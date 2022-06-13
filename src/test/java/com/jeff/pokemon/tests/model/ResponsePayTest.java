package com.jeff.pokemon.tests.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jeff.pokemon.model.ResponsePay;

public class ResponsePayTest {
    
    private ResponsePay<String> response;
    private ArrayList lista;
    @BeforeEach
    public void init(){
        //coverage test
        response = new ResponsePay<>(null);
        lista = new ArrayList<>();
        response.setResult(lista);
    }

    @Test
    public void getResultTest(){
        assertEquals(lista, response.getResult());
    }
    
}
