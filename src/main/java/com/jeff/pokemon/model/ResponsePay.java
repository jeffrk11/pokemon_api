package com.jeff.pokemon.model;

import java.util.List;

public class ResponsePay<T> {

    private List<T> result;

    public ResponsePay(List<T> pokemons){
        this.result = pokemons;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

}
