package com.casechek.sprint_tools.service;

import com.casechek.sprint_tools.persistence.repository.DevTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*

1. we want to: retrieve the values saved through the post mapping for a specific team

2. we use the DevTeamRepository to interface object to store the data. the repository acts as the crud mechanism for the
@Entity / @Table 'DevTeam Entity' -- so we'll need to call the repository to get the data we need.

*/


@Service
public class SprintCapacityService {

    private final DevTeamRepository devTeamRepository;

    @Autowired
    public SprintCapacityService(DevTeamRepository devTeamRepository) {
        this.devTeamRepository = devTeamRepository;
    }
}
