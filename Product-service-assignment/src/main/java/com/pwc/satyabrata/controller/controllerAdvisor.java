package com.pwc.satyabrata.controller;

import java.util.InputMismatchException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pwc.satyabrata.myException.productAlreadyCreatedException;
import com.pwc.satyabrata.myException.productNotFoundException;

public class controllerAdvisor {
	@ExceptionHandler(productAlreadyCreatedException.class)
	public ResponseEntity<?> productAlreadyCreatedException(productAlreadyCreatedException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	
	@ExceptionHandler(productNotFoundException.class)
	public ResponseEntity<?> productNotFoundException(productNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	
	@ExceptionHandler(InputMismatchException.class)
	public ResponseEntity<?> InputMismatchException(InputMismatchException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

}


