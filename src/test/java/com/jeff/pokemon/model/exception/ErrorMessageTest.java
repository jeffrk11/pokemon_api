package com.jeff.pokemon.model.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ErrorMessageTest {
    
    private ErrorMessage error;

    @BeforeEach
    public void init(){
        error = new ErrorMessage("123", "message");
        error.setError("message");
        error.setTimestamp("123");
    }

    @Test
    public void getTimestampTest(){
        assertEquals("123", error.getTimestamp());
    }
    @Test
    public void getErrorTest(){
        assertEquals("message", error.getError());
    }
}
