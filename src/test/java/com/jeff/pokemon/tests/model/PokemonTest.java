package com.jeff.pokemon.tests.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jeff.pokemon.model.Pokemon;

public class PokemonTest {
    
    private Pokemon pokemon;

    @BeforeEach
    public void init(){
        //coverage test
        pokemon = new Pokemon("pikachu");
        pokemon = new Pokemon("pikachu", "chu");
        pokemon.setName("pikachu");
        pokemon.setHighlight("chu");
    }

    @Test
    public void getNameTest(){
        assertEquals("pikachu", pokemon.getName());
    }
    @Test
    public void getHighlightTest(){
        assertEquals("chu", pokemon.getHighlight());
    }

    
}
