package com.casechek.sprint_tools.repository;

import com.casechek.sprint_tools.persistence.entity.DevTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevTeamRepository extends CrudRepository<DevTeam, String> {
}
