package com.casechek.sprint_tools.service;

import com.casechek.sprint_tools.persistence.entity.DevTeam;
import com.casechek.sprint_tools.repository.DevTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

/*

1. we want to: retrieve the values saved through the post mapping for a specific team

2. we use the DevTeamRepository interface object to store the data. the repository acts as the crud mechanism for the
@Entity / @Table 'DevTeam Entity' -- so we'll need to call the repository to get the data we need.

*/


@Service
public class SprintCapacityService {

    private final DevTeamRepository devTeamRepository;

    @Autowired
    public SprintCapacityService(DevTeamRepository devTeamRepository) {
        this.devTeamRepository = devTeamRepository;
    }

    public String calculate(DevTeam devTeam) {
        Integer sprintCapacity = 0;

        float sprintDayCapacity = (((float)(devTeam.getDaysInSprint() - devTeam.getHolidays()) /
                devTeam.getDaysInSprint()) * devTeam.getAverageVelocity());
        float teamCapacity = (float)((devTeam.getDaysInSprint() * devTeam.getDeveloperCount()) - devTeam.getPtoTotal())
                / (devTeam.getDaysInSprint() * devTeam.getDeveloperCount());
        String teamCapacityFormatted = NumberFormat.getPercentInstance().format(teamCapacity);
        sprintCapacity = Math.round(sprintDayCapacity * teamCapacity);

        System.out.println("Your team is operating at " + teamCapacityFormatted);
        System.out.println("Look to add " + sprintCapacity + " points to your next sprint");
        devTeamRepository.save(devTeam);

        return "Your team is operating at: " + teamCapacityFormatted + " -- Add: " + sprintCapacity + " points to your next sprint!";
    }
}
