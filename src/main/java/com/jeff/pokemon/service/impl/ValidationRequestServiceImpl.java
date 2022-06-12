package com.jeff.pokemon.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeff.pokemon.exceptions.BusinessException;
import com.jeff.pokemon.model.enums.SortType;
import com.jeff.pokemon.service.ValidationRequestService;

public class ValidationRequestServiceImpl implements ValidationRequestService{
    private final Logger log = LoggerFactory.getLogger("LOGGER");

    @Override
    public void validationRequest(String name, SortType sort) {
        log.info(">>Validating request..");

        if(name == null || name.isEmpty())
            throw new BusinessException("Pokemon name not provided");
            
        if(sort == null){
            log.info("Sorting type not provided, set default ALPHABETICAL");
            sort = SortType.ALPHABETICAL;
        }

        log.info(">>Validation ok");
    }
    
}
