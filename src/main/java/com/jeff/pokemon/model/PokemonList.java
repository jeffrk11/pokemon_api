package com.jeff.pokemon.model;

import java.util.List;

public class PokemonList<T> {

    private List<T> result;

    public PokemonList(List<T> pokemons){
        this.result = pokemons;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

}
