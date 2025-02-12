package com.poppulo.lottery.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GlobalExceptionHandlerTests {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHandleNotFoundException() {
        NotFoundException ex = new NotFoundException("Resource not found");

        ResponseEntity<?> response = globalExceptionHandler.handleNotFoundException(ex, mock(WebRequest.class));

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        GlobalExceptionHandler.ErrorDetails errorDetails = (GlobalExceptionHandler.ErrorDetails) response.getBody();
        assertEquals(HttpStatus.NOT_FOUND.value(), errorDetails.getStatusCode());
        assertEquals("Resource not found", errorDetails.getMessage());
    }

    @Test
    void testHandleBadRequestException() {
        BadRequestException ex = new BadRequestException("Bad request");

        ResponseEntity<?> response = globalExceptionHandler.handleBadRequestException(ex, mock(WebRequest.class));

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        GlobalExceptionHandler.ErrorDetails errorDetails = (GlobalExceptionHandler.ErrorDetails) response.getBody();
        assertEquals(HttpStatus.BAD_REQUEST.value(), errorDetails.getStatusCode());
        assertEquals("Bad request", errorDetails.getMessage());
    }

    @Test
    void testHandleValidationException() throws Exception {
        
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = new FieldError("objectName", "field", "defaultMessage");
        when(bindingResult.getAllErrors()).thenReturn(Collections.singletonList(fieldError));

        Method method = this.getClass().getDeclaredMethod("dummyMethod");
        MethodParameter methodParameter = new MethodParameter(method, -1);

        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(methodParameter, bindingResult);

        ResponseEntity<?> response = globalExceptionHandler.handleValidationException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals(1, responseBody.size());
        assertEquals("defaultMessage", responseBody.get("field"));
    }

    @Test
    void testHandleConstraintViolationException() {
        Set<ConstraintViolation<?>> violations = new HashSet<>();
        ConstraintViolationException ex = new ConstraintViolationException(violations);

        ResponseEntity<?> response = globalExceptionHandler.handleConstraintViolationException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(0, ((Map<?, ?>) response.getBody()).size());
    }

    
}
