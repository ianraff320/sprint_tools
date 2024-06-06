package com.casechek.sprint_tools.api;

import com.casechek.sprint_tools.persistence.entity.devTeam;
import com.casechek.sprint_tools.persistence.repository.devTeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import java.net.URI;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/devteam")
class devTeamController {
    private final devTeamRepository devTeamRepository;

    private devTeamController(devTeamRepository devTeamRepository) {
        this.devTeamRepository = devTeamRepository;
    }

    @GetMapping("/{requestedTeamName}")
    private ResponseEntity<devTeam> findById(@PathVariable String requestedTeamName) {
        Optional<devTeam> devTeamOptional = devTeamRepository.findById(requestedTeamName);
        if (devTeamOptional.isPresent()) {
            return ResponseEntity.ok(devTeamOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createDevTeam(@RequestBody devTeam newDevTeamRequest,
                                                     UriComponentsBuilder ucb) {
        devTeam savedDevTeam = devTeamRepository.save(newDevTeamRequest);
        URI locationOfNewDevTeam = ucb
                .path("devteam/{requestedTeamName}")
                .buildAndExpand(savedDevTeam.getTeamName())
                .toUri();
        return ResponseEntity.created(locationOfNewDevTeam).build();
    }
}
