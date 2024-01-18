package com.app.exc_handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;

@RestControllerAdvice // to tell SC following is centralized custom exc handler , 
//to provide COMMON ADVICE to all rest controllers regarding exc handling
public class GlobalExceptionHandler {
	//add exc handling method : for validation failures
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException
	(MethodArgumentNotValidException e)
	{
		System.out.println("in meth arg invalid "+e);
		List<FieldError> errList=e.getFieldErrors();
//		Map<String, String> errMap=new HashMap<>();
//		for(FieldError err : errList)
//			errMap.put(err.getField(), err.getDefaultMessage());
		//OR
		Map<String, String> map = errList.stream() //Stream<FieldError> collection --> stream
		.collect(
				Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));//f -> f.getField(), f -> f.getDefaultMessage()
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	//add exc handling method : for resource not found exc
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException
	(ResourceNotFoundException e){
		System.out.println("in res not found exc");
		return ResponseEntity.status
				(HttpStatus.NOT_FOUND).
				body(new ApiResponse(e.getMessage()));
	}
	//add exc handling method : for all remaining excs
		@ExceptionHandler(Exception.class)
		public ResponseEntity<?> handleException
		(Exception e){
			System.out.println("in catch-all  exc");
			e.printStackTrace();
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR).
					body(new ApiResponse(e.getMessage()));
		}
	

}
