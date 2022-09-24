package com.iacsd.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.iacsd.helperobjects.Maps;

@CrossOrigin
@ControllerAdvice
public class RestControllerExceptionHandler {
	
	@ExceptionHandler({org.hibernate.exception.ConstraintViolationException.class})
	public ResponseEntity<?> handleUniqueEmailException(){
		Map<String,Object> map = Maps.getMap();
		map.put("status","error");
		map.put("error","User with this email account already exists");
		return ResponseEntity.ok(map);
	}
	
	
}
