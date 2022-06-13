package com.jeff.pokemon.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;

import com.jeff.pokemon.exceptions.TechnicalException;
import com.jeff.pokemon.model.responseapi.PayloadResponse;
import com.jeff.pokemon.service.impl.PokeApiServiceImpl;
import com.jeff.pokemon.utils.http.HttpHelper;

@ExtendWith(MockitoExtension.class)
public class PokeApiServiceTest {
    
    @InjectMocks PokeApiServiceImpl service;
    private LocalDateTime time;
    @Mock HttpResponse<String> response;
    @Mock HttpHelper http;
    @Mock private PayloadResponse payloadResp;

    @BeforeEach
    public void init(){
        ReflectionTestUtils.setField(service, "http", http);
        time = time.of(2000, Month.APRIL, 1, 0, 0);
        ReflectionTestUtils.setField(service,"time",time);
        payloadResp = new PayloadResponse();
        payloadResp.setResults(new ArrayList<>());
        ReflectionTestUtils.setField(service, "payloadResp", payloadResp);
    }
    
    @Test
    public void getAllPokemonsIfTrueUpdatePayloadOk() throws Exception{
        Mockito.when(response.statusCode()).thenReturn(HttpStatus.OK.value());
        Mockito.when(response.body()).thenReturn("{\"count\": 123, \"results\": []}");
        Mockito.when(http.doGet(Mockito.anyString())).thenReturn(response);

        assertNotNull(service.getAllPokemons());
    }
    
    @Test
    public void getAllPokemonsIfTrueUpdatePayloadBadRequest() throws Exception{
        Mockito.when(response.statusCode()).thenReturn(HttpStatus.BAD_REQUEST.value());
        Mockito.when(http.doGet(Mockito.anyString())).thenReturn(response);

        assertNotNull(service.getAllPokemons());
    }

    @Test
    public void getAllPokemonsIfTrueUpdatePayloadException() throws Exception{
        Mockito.when(http.doGet(Mockito.anyString())).thenThrow(new TechnicalException("message"));
        
        assertThrows(TechnicalException.class,() -> service.getAllPokemons());
    }

}
