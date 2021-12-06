package io.agileintelligence.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {
//THIS MAPVALI... ENSURES WE ARE GETTING A VALID PROJECT OBJECT
	public ResponseEntity<?> MapValidationService(BindingResult result) {
		if (result.hasErrors()) {

			Map<String, String> errorMap = new HashMap<>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}

			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
			// we return the "errorMap incase we have any issues running it
		}
		return null;
	}

}
