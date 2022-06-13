package com.jeff.pokemon.tests.exceptions;

import org.junit.jupiter.api.Test;

import com.jeff.pokemon.exceptions.TechnicalException;

public class TechnicalExceptionTest {
    
    @Test
    public void TechnicalExceptionTest(){
        //coverage test
        new TechnicalException("message");
    }
}
