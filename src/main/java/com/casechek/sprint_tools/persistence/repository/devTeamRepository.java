package com.casechek.sprint_tools.persistence.repository;

import com.casechek.sprint_tools.persistence.entity.devTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface devTeamRepository extends CrudRepository<devTeam, String> {
}
