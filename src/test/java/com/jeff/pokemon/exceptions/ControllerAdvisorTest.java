package com.jeff.pokemon.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.MissingServletRequestParameterException;

public class ControllerAdvisorTest {
    
    private ControllerAdvisor advisor;

    @BeforeEach
    public void init(){
        advisor = new ControllerAdvisor();
    }

    @Test
    public void handlerTechnicalExceptionTest(){
        assertNotNull(advisor.handlerTechnicalException(new TechnicalException("message")));
    }
    @Test
    public void handlerBusinessExceptionTest(){
        assertNotNull(advisor.handlerBusinessException(new BusinessException("message")));
    }
    @Test
    public void handlerMissingParameterTest(){
        assertNotNull(advisor.handlerMissingParameter(new MissingServletRequestParameterException("any","any")));
    }
    @Test
    public void handlerIllegalArgumentExceptionTest(){
        ConversionFailedException e = new ConversionFailedException(null, null, null, null);
        assertNotNull(advisor.handlerIllegalArgumentException( e));
    }
}
