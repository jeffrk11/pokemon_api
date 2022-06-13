package com.jeff.pokemon.tests.exceptions;

import org.junit.jupiter.api.Test;

import com.jeff.pokemon.exceptions.TechnicalException;

public class BusinessExceptionTest {
    
    @Test
    public void BusinessExceptionTest(){
        //coverage test
        new TechnicalException("message");
    }
}
