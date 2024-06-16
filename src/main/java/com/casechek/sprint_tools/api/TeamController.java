package com.casechek.sprint_tools.api;

import com.casechek.sprint_tools.persistence.entity.Developer;
import com.casechek.sprint_tools.persistence.entity.Team;
import com.casechek.sprint_tools.persistence.repository.DeveloperRepository;
import com.casechek.sprint_tools.persistence.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamRepository teamRepository;
    private final DeveloperRepository developerRepository;

    public TeamController(TeamRepository teamRepository, DeveloperRepository developerRepository) {
        this.teamRepository = teamRepository;
        this.developerRepository = developerRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        return teamOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team newTeamRequest) {
        Team savedTeam = teamRepository.save(newTeamRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team updateTeamRequest) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team existingTeam = teamOptional.get();
            existingTeam.setTeamName(updateTeamRequest.getTeamName());
            Team savedTeam = teamRepository.save(existingTeam);
            return ResponseEntity.ok(savedTeam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/developers")
    public ResponseEntity<Team> addDeveloperToTeam(
            @PathVariable Long id,
            @RequestBody Long developerId
    ) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        Optional<Developer> developerOptional = developerRepository.findById(developerId);

        if (teamOptional.isPresent() && developerOptional.isPresent()) {
            Team team = teamOptional.get();
            Developer developer = developerOptional.get();

            team.addDeveloper(developer);
            developerRepository.save(developer);
            teamRepository.save(team);
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
