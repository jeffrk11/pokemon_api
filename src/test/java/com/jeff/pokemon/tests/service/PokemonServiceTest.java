package com.jeff.pokemon.tests.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.jeff.pokemon.exceptions.TechnicalException;
import com.jeff.pokemon.model.Pokemon;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.PokeApiService;
import com.jeff.pokemon.service.impl.PokemonServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {
    
    @InjectMocks PokemonServiceImpl service;
    @Mock private PokeApiService pokeApi;

    @BeforeEach
    public void init(){
        ReflectionTestUtils.setField(service, "pokeApi", pokeApi);
    }

    @Test
    public void getPokemonsOk(){
        var pokemons = new ArrayList<Pokemon>();
        pokemons.add(new Pokemon("pikachu"));
        Mockito.when(pokeApi.getAllPokemons()).thenReturn(pokemons);

        assertEquals(1, service.getPokemons("pikachu").size());
    }
    @Test
    public void getPokemonsNameNull(){
        var pokemons = new ArrayList<Pokemon>();
        pokemons.add(new Pokemon("pikachu"));
        Mockito.when(pokeApi.getAllPokemons()).thenReturn(pokemons);

        assertEquals(0, service.getPokemons(null).size());
    }
    @Test
    public void getPokemonsException(){
        Mockito.when(pokeApi.getAllPokemons()).thenReturn(new ArrayList<>());

        assertThrows(TechnicalException.class,() -> service.getPokemons(null));
    }

    @Test void findPokemonByNameTest(){
        var pokemons = new ArrayList<Pokemon>();
        pokemons.add(new Pokemon("pikachu"));
        pokemons.add(new Pokemon("pichu"));
        Mockito.when(pokeApi.getAllPokemons()).thenReturn(pokemons);

        assertNotNull(service.findPokemonByName("chu", SortType.ALPHABETICAL));
    }

    @Test void findPokemonByNameHighlightTest(){
        var pokemons = new ArrayList<Pokemon>();
        pokemons.add(new Pokemon("pikachu"));
        pokemons.add(new Pokemon("pichu"));
        Mockito.when(pokeApi.getAllPokemons()).thenReturn(pokemons);

        assertNotNull(service.findPokemonByNameHighlight("chu", SortType.ALPHABETICAL));
    }
}
