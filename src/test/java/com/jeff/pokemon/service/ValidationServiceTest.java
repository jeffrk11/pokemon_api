package com.jeff.pokemon.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jeff.pokemon.exceptions.BusinessException;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.impl.ValidationRequestServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ValidationServiceTest {
    
    @InjectMocks ValidationRequestServiceImpl validation;

    @Test
    public void validationNameOk(){
        assertEquals("abc", validation.validationName("ABC"));
    }
    @Test
    public void validationNameNull(){
        assertThrows(BusinessException.class,() -> validation.validationName(null));
    }
    @Test
    public void validationNameBlank(){
        assertThrows(BusinessException.class,() -> validation.validationName(""));
    }

    @Test
    public void validationSortTyypeNotNull(){
        assertEquals(SortType.ALPHABETICAL,validation.validationSortType(SortType.ALPHABETICAL));
    }
    @Test
    public void validationSortTypeNull(){
        assertEquals(SortType.ALPHABETICAL,validation.validationSortType(null));
    }

}
