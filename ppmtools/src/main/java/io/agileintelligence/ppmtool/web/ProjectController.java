package io.agileintelligence.ppmtool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.services.ProjectService;



//This wehre we will hit the API

@RestController
@RequestMapping("/api/project")//api and project are the route
public class ProjectController {

	//for api we will hit we use the contorller
	
	@Autowired //for enabling 
	private ProjectService projectService;
	
	
	
	@PostMapping("")// we will make the route for afterwards which will return response entity
	public ResponseEntity<Project>createNewProject(@RequestBody Project project){
		Project project1 = projectService.saveOrUpdateProject(project);
		
		//have more contorl on JSON repsonses cuzz we will set up with React
			return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	//responsenentity gives us contorl over json reponses...our method is createNewPRoject
		
	}
	
	
	
}
