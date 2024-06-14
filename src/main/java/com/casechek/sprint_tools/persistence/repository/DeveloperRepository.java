package com.casechek.sprint_tools.persistence.repository;

import com.casechek.sprint_tools.persistence.entity.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {
}
