package io.agileintelligence.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice//helps break away from havng exception handlers that are contorllere specific...like a glod exception handler
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	//b
		@ExceptionHandler
		public final ResponseEntity<Object> handleProjectException(ProjectIdException ex, WebRequest request){
			
			//below is the response
			ProjectIdExceptionResponse exceptionResponse = new ProjectIdExceptionResponse(ex.getMessage());
					return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		}
}
