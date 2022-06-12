package com.jeff.pokemon.model.response;

import java.util.List;

import com.jeff.pokemon.model.Pokemon;

public class PayloadResponse {
    private int count;
    private List<Pokemon> results;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public List<Pokemon> getResults() {
        return results;
    }
    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
