package io.agileintelligence.ppmtool.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.services.ProjectService;



//This wehre we will hit the API

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	
	@Autowired //for enabling 
	private ProjectService projectService;
	
	
	
	@PostMapping("")// we will make the route for afterwards which will return response entity
	public ResponseEntity<?>createNewProject(@Valid @RequestBody Project project, BindingResult result){
	
		if(result.hasErrors()) {
			
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error: result.getFieldErrors()) {
				errorMap.put(error.getField(),error.getDefaultMessage());
			}
			
			return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
			//we return the "errorMap incase we have any issues running it
		}
		
		
		Project project1 = projectService.saveOrUpdateProject(project);
			return new ResponseEntity<Project>(project, HttpStatus.CREATED);

	}
	
	
	
}
