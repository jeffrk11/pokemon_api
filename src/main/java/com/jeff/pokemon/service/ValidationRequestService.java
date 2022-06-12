package com.jeff.pokemon.service;

import com.jeff.pokemon.model.enums.SortType;

public interface ValidationRequestService {
    
    /**
     * It validates the request.
     * <p> check if name and sort exist</p>
     * 
     * @param name The name of the pokemon you want to validate.
     * @param sort The sort type of the list.
     */
    public void validationRequest(String name, SortType sort);

}
