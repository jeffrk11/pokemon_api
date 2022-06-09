package com.jeff.pokemon.model.response;

import java.util.List;

public class PayloadResponse {
    private int count;
    private List<PokemonName> results;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public List<PokemonName> getResults() {
        return results;
    }
    public void setResults(List<PokemonName> results) {
        this.results = results;
    }
}
