package io.agileintelligence.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.agileintelligence.ppmtool.domain.Backlog;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {
	
	//jpa allows us to set up queries
	//this returns a backlog object and we can wire into projectservice
	Backlog findByProjectIdentifier(String Identifier);
}


