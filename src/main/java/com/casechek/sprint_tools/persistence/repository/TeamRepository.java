package com.casechek.sprint_tools.persistence.repository;

import com.casechek.sprint_tools.persistence.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
}
