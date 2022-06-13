package com.jeff.pokemon.tests.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.jeff.pokemon.controller.PokemonController;
import com.jeff.pokemon.model.ResponsePay;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.PokemonService;
import com.jeff.pokemon.service.ValidationRequestService;

@ExtendWith(MockitoExtension.class)
public class PokemonControllerTest {

    @InjectMocks private PokemonController controller;
    @Mock private PokemonService service;
    @Mock private ValidationRequestService validation;

    @BeforeEach
    public void init(){
        ReflectionTestUtils.setField(controller,"service", service);
        ReflectionTestUtils.setField(controller,"validation", validation);
    }

    @Test
    public void findPokemonsTest() throws Exception{
        Mockito.when(validation.validationName(Mockito.anyString())).thenReturn("pikachu");
        Mockito.when(validation.validationSortType(Mockito.any())).thenReturn(SortType.ALPHABETICAL);

        Mockito.when(service.findPokemonByName(Mockito.anyString(), Mockito.any())).thenReturn(new ResponsePay<>(null));

        assertNotNull(controller.findPokemons("any", SortType.ALPHABETICAL));
    }
    @Test
    public void findPokemonsHighlightTest() throws Exception{
        Mockito.when(validation.validationName(Mockito.anyString())).thenReturn("pikachu");
        Mockito.when(validation.validationSortType(Mockito.any())).thenReturn(SortType.ALPHABETICAL);

        Mockito.when(service.findPokemonByNameHighlight(Mockito.anyString(), Mockito.any())).thenReturn(new ResponsePay<>(null));

        assertNotNull(controller.findPokemonsHighlight("any", SortType.ALPHABETICAL));
    }
}
