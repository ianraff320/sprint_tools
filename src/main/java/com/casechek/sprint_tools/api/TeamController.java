package com.casechek.sprint_tools.api;

import com.casechek.sprint_tools.persistence.entity.Team;
import com.casechek.sprint_tools.persistence.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import java.net.URI;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/teams")
class TeamController {
    private final TeamRepository teamRepository;


    private TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Team> findById(@PathVariable("id") Long requestedId) {
        Optional<Team> teamOptional = teamRepository.findById(requestedId);
        if (teamOptional.isPresent()) {
            return ResponseEntity.ok(teamOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Team> createTeam(@RequestBody Team newTeamRequest) {
        Team savedTeam = teamRepository.save(newTeamRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }
}
