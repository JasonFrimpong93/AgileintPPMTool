package io.agileintelligence.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.agileintelligence.ppmtool.domain.ProjectTask;


@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
}
