package com.jeff.pokemon.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeff.pokemon.exceptions.BusinessException;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.ValidationRequestService;

public class ValidationRequestServiceImpl implements ValidationRequestService{
    private final Logger log = LoggerFactory.getLogger("LOGGER");

    @Override
    public String validationName(String name) {
        log.info(">>Validating name..");
        if(name == null || name.isEmpty())
            throw new BusinessException("Pokemon name not provided");
            
        return name.toLowerCase();
    }

    @Override
    public SortType validationSortType(SortType sortType) {
        log.info(">>Validating sortType..");
        
        if(sortType == null){
            log.info(">Sorting type not provided, set default ALPHABETICAL");
            return SortType.ALPHABETICAL;
        }
        return sortType;
    }
    
}
