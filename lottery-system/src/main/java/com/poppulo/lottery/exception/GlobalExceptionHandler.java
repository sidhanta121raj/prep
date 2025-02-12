package com.poppulo.lottery.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.poppulo.lottery.service.impl.LotterySystemServiceImpl;

import jakarta.validation.ConstraintViolationException;

/**
 * @author kalingas
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(LotterySystemServiceImpl.class);
	
	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex, WebRequest request) {
		log.error("NotFoundException: {}", ex.getMessage());
		
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException ex, WebRequest request) {
		log.error("BadRequestException: {}", ex.getMessage());
        
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
	
	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
		log.error("MethodArgumentNotValidException: {}", ex.getMessage());
        
		Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex) {
    	log.error("ConstraintViolationException: {}", ex.getMessage());
        
    	Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	/**
	 * 
	 */
	public static class ErrorDetails {
        private int statusCode;
        private String message;

        public ErrorDetails(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }
        
        /**
         * @return
         */
        public int getStatusCode() {
			return statusCode;
		}

		/**
		 * @param statusCode
		 */
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		/**
		 * @return
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @param message
		 */
		public void setMessage(String message) {
			this.message = message;
		}


       
    }

}
