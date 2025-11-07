package com.fitmind.exceptions;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	import java.time.LocalDateTime;
	import java.util.HashMap;
	import java.util.Map;

	@ControllerAdvice
	public class GlobalHandlerException {

	    /**
	     * Handle custom UserAlreadyHasProfile exception
	     */
	    @ExceptionHandler(UserAlreadyHasProfile.class)
	    public ResponseEntity<Map<String, Object>> handleUserAlreadyHasProfile(UserAlreadyHasProfile ex) {
	        Map<String, Object> errorBody = new HashMap<>();
	        errorBody.put("timestamp", LocalDateTime.now());
	        errorBody.put("status", HttpStatus.CONFLICT.value());
	        errorBody.put("error", "User Already Has Profile");
	        errorBody.put("message", ex.getMessage());

	        return new ResponseEntity<>(errorBody, HttpStatus.CONFLICT);
	    }

	    /**
	     * Handle all uncaught exceptions globally
	     */
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
	        Map<String, Object> errorBody = new HashMap<>();
	        errorBody.put("timestamp", LocalDateTime.now());
	        errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorBody.put("error", "Internal Server Error");
	        errorBody.put("message", ex.getMessage());

	        // Optionally log the full exception stack trace
	        ex.printStackTrace();

	        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


