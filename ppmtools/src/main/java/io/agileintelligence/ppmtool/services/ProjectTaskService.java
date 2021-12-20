package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.ProjectTask;
import io.agileintelligence.ppmtool.repositories.BacklogRepository;
import io.agileintelligence.ppmtool.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {

	
	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	public ProjectTask addProjectTask() {
		
		//PTs to be added to a specific project, project != null, means backlog exist
		//then we want to setbacklog to projecttask, then we want to talk about projectsequence(that is ptsequence_
		
		 //we want our project sequence to be like this: IDPRO-1 IDPRO-2 
			//It will be projectIdentifiera and our Id together like this IDPRO-ID, which will be within  project
			// you want things to be chronologically order therefore if you delete one it still goes to the next number 
			//then we want to update Back log SEQUENCE
		
			//INITIAL priority when priority null
			//INITIAL status when stauts is null
		
		
		
	}
}
