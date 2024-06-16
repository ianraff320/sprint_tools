//package com.casechek.sprint_tools.service;
//
//import com.casechek.sprint_tools.persistence.entity.Team;
//import com.casechek.sprint_tools.persistence.repository.TeamRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.NumberFormat;
//
///*
//
//1. we want to: retrieve the values saved through the post mapping for a specific team
//
//2. we use the DevTeamRepository interface object to store the data. the repository acts as the crud mechanism for the
//@Entity / @Table 'DevTeam Entity' -- so we'll need to call the repository to get the data we need.
//
//*/
//
//
//@Service
//public class SprintCapacityService {
//
//    private final TeamRepository teamRepository;
//
//    @Autowired
//    public SprintCapacityService(TeamRepository teamRepository) {
//        this.teamRepository = teamRepository;
//    }
//
//    public String calculate(Team team) {
//        Integer sprintCapacity = 0;
//
//        float sprintDayCapacity = (((float)(team.getStartDate() - team.getHolidays()) /
//                team.getStartDate()) * team.getAverageVelocity());
//        float teamCapacity = (float)((team.getStartDate() * team.getDeveloperCount()) - team.getPtoTotal())
//                / (team.getStartDate() * team.getDeveloperCount());
//        String teamCapacityFormatted = NumberFormat.getPercentInstance().format(teamCapacity);
//        sprintCapacity = Math.round(sprintDayCapacity * teamCapacity);
//
//        System.out.println("Your team is operating at " + teamCapacityFormatted); // need to divide this by "time based" capacity (day capacity * average)
//        System.out.println("Look to add " + sprintCapacity + " points to your next sprint");
//        teamRepository.save(team);
//
//        return "Your team is operating at: " + teamCapacityFormatted + " -- Add: " + sprintCapacity + " points to your next sprint!";
//    }
//}
