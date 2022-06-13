package com.jeff.pokemon.utils.http;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.jeff.pokemon.utils.http.HttpHelper;

public class HttpHelperTest {
    private HttpHelper http;

    @Test
    public void testException(){
        assertThrows(Exception.class, () -> http.doGet("invalidlink"));
    }
}
