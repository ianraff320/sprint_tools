package com.casechek.sprint_tools.api;

import com.casechek.sprint_tools.persistence.entity.DevTeam;
import com.casechek.sprint_tools.repository.DevTeamRepository;
import com.casechek.sprint_tools.service.SprintCapacityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import java.net.URI;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/devteam")
class DevTeamController {
    private final DevTeamRepository devTeamRepository;

    private final SprintCapacityService sprintCapacityService;

    private DevTeamController(DevTeamRepository devTeamRepository,
                              SprintCapacityService sprintCapacityService) {
        this.devTeamRepository = devTeamRepository;
        this.sprintCapacityService = sprintCapacityService;
    }

    @GetMapping("/{requestedTeamName}")
    private ResponseEntity<DevTeam> findById(@PathVariable String requestedTeamName) {
        Optional<DevTeam> devTeamOptional = devTeamRepository.findById(requestedTeamName);
        if (devTeamOptional.isPresent()) {
            return ResponseEntity.ok(devTeamOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createDevTeam(@RequestBody DevTeam newDevTeamRequest,
                                                     UriComponentsBuilder ucb) {
        DevTeam savedDevTeam = devTeamRepository.save(newDevTeamRequest);
        URI locationOfNewDevTeam = ucb
                .path("devteam/{requestedTeamName}")
                .buildAndExpand(savedDevTeam.getTeamName())
                .toUri();
        return ResponseEntity.created(locationOfNewDevTeam).build();
    }

    @PostMapping("/calculate")
    private ResponseEntity<String> calculateSprint(@RequestBody DevTeam newDevTeamRequest) {
        String sprintCapacity = sprintCapacityService.calculate(newDevTeamRequest);
        return ResponseEntity.ok(sprintCapacity);
    }
}
