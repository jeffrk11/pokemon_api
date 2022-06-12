package com.jeff.pokemon.service;

import com.jeff.pokemon.model.enums.SortType;

public interface ValidationRequestService {
    


    /**
     * Check if the name exist and update it with lower case
     * 
     * @param name The name of the field to be validated.
     * @return the name in lower case.
     */
    public String validationName(String name);


    /**
     * > If the sortType is not provided, then return the default sort type
     * 
     * @param sortType The sort type to validate.
     * @return The sortType is being returned, default is ALPHABETICAL.
     */
    public SortType validationSortType(SortType sortType);
}
