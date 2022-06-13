package com.jeff.pokemon.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jeff.pokemon.model.enums.SortType;

public class SortUtilsTest {
    
    @Test
    public void sortTest(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bd");
        
        assertNotNull(SortUtils.sort(list, SortType.ALPHABETICAL));
    }
}
