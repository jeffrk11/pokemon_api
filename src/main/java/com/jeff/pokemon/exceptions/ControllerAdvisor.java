package com.jeff.pokemon.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jeff.pokemon.model.exception.ErrorMessage;

@ControllerAdvice
public class ControllerAdvisor {
    
    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ErrorMessage> handlerTechnicalException(TechnicalException e){
        return new ResponseEntity<>(new ErrorMessage(LocalDateTime.now().toString(), e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
