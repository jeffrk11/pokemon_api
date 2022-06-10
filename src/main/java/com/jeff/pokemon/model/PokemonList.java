package com.jeff.pokemon.model;

import java.util.List;

public class PokemonList {

    private List<String> result;

    public PokemonList(List<String> names){
        this.result = names;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

}
