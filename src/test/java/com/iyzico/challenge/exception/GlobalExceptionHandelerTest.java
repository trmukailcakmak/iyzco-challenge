package com.iyzico.challenge.exception;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandelerTest {

    @InjectMocks
    private GlobalExceptionHandeler globalExceptionHandeler;

    @Mock
    private MessageSource messageSource;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void handleIyzicoException() {
        Mockito.when(this.messageSource.getMessage(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn("test-message-success");
        ResponseEntity<Object> response = globalExceptionHandeler.handleIyzicoException(new IyzicoException("Test"));
        Assert.assertNotNull(response);
    }

    @Test
    public void handleException() {
        Mockito.when(this.messageSource.getMessage(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn("test-message-success");
        ResponseEntity<Object> response = globalExceptionHandeler.handleException(new Exception());
        Assert.assertNotNull(response);
    }
}