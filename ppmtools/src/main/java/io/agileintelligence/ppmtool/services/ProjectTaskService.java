package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.Backlog;
import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.domain.ProjectTask;
import io.agileintelligence.ppmtool.exceptions.ProjectNotFoundException;
import io.agileintelligence.ppmtool.repositories.BacklogRepository;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import io.agileintelligence.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

	
	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	 @Autowired
	    private ProjectRepository projectRepository;
	
	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
	try {//PTs to be added to a specific project, project != null, means backlog exist
		//then we want to setbacklog to projecttask, then we want to talk about projectsequence(that is ptsequence_
		
		//set b; to pt
		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
		//
		
		
		projectTask.setBacklog(backlog);
		//we want our project sequence to be like this: IDPRO-1 IDPRO-2 
			//It will be projectIdentifiera and our Id together like this IDPRO-ID, which will be within  project
			Integer BacklogSequence = backlog.getPTSequence();
			BacklogSequence++;
			// you want things to be chronologically order therefore if you delete one it still goes to the next number 
			//then we want to update Back log SEQUENCE
			backlog.setPTSequence(BacklogSequence);
			
			// add seq to projectstask
			projectTask.setProjectSequence(projectIdentifier+"-"+BacklogSequence);
			projectTask.setProjectIdentifier(projectIdentifier);
			
			
			//INITIAL status when stauts is null
			if(projectTask.getStatus()==""||projectTask.getStatus()==null) {
			projectTask.setStatus("TO_DO");
			}
			
			//INITIAL priority when priority null
			if(projectTask.getPriority()==null) {
				projectTask.setPriority(3);
			}
			
				return projectTaskRepository.save(projectTask);
		
	}catch (Exception e) {
		throw new ProjectNotFoundException("Project Not Found");
	}
		
	}
	public Iterable<ProjectTask>findBacklogById(String id){
		
		Project project = projectRepository.findByProjectIdentifier(id);

        if(project==null){
            throw new ProjectNotFoundException("Project with ID: '"+id+"' does not exist");
        }
        
		return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
		
	}
	 public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id){

	        //make sure we are searching on the right backlog

	        return projectTaskRepository.findByProjectSequence(pt_id);
	    }
}
