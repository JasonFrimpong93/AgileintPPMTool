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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.services.MapValidationErrorService;
import io.agileintelligence.ppmtool.services.ProjectService;



//This wehre we will hit the API

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	
	@Autowired //for enabling 
	private ProjectService projectService;
	
	
	@Autowired
	private MapValidationErrorService mapValidationService;
	
	
	@PostMapping("")// we will make the route for afterwards which will return response entity
	public ResponseEntity<?>createNewProject(@Valid @RequestBody Project project, BindingResult result){
	
		ResponseEntity<?> errorMap = mapValidationService.MapValidationService(result);
		if(errorMap !=null) {
			return errorMap;
		}
		
		//This is returned when we have an invalid object 
		
		Project project1 = projectService.saveOrUpdateProject(project);
			return new ResponseEntity<Project>(project, HttpStatus.CREATED);

	}
	
	@GetMapping("/{projectId}")//will pull data when you enter
	public ResponseEntity<?> getProjectById(@PathVariable String projectId){
		Project project = projectService.findProjectByIdentifier(projectId);
		
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Project> getAllProjects(){return projectService.findAllProjects();}
}
