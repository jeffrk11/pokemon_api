package com.jeff.pokemon.exceptions;

import java.time.LocalDateTime;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jeff.pokemon.model.exception.ErrorMessage;

@ControllerAdvice
public class ControllerAdvisor {
    
    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ErrorMessage> handlerTechnicalException(TechnicalException e){
        return new ResponseEntity<>(new ErrorMessage(LocalDateTime.now().toString(), 
                                                        e.getMessage()),
                                                        HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handlerBusinessException(BusinessException e){
        return new ResponseEntity<>(new ErrorMessage(LocalDateTime.now().toString(), 
                                                        e.getMessage()),
                                                        HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorMessage> handlerMissingParameter(MissingServletRequestParameterException e){
        return new ResponseEntity<>(new ErrorMessage(LocalDateTime.now().toString(), 
                                                        "Missing parameter: "+e.getParameterName()),
                                                        HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<ErrorMessage> handlerIllegalArgumentException(ConversionFailedException e){
        return new ResponseEntity<>(new ErrorMessage(LocalDateTime.now().toString(), 
                                                        String.format("Sort type %s does not exist",e.getValue())),
                                                        HttpStatus.BAD_REQUEST);
    }
}
