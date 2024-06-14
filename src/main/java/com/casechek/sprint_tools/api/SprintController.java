//package com.casechek.sprint_tools.api;
//
//import com.casechek.sprint_tools.persistence.entity.Team;
//import com.casechek.sprint_tools.persistence.repository.TeamRepository;
//import com.casechek.sprint_tools.service.SprintCapacityService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/team")
//class SprintController {
//    private final TeamRepository teamRepository;
//
//    private final SprintCapacityService sprintCapacityService;
//
//    private SprintController(TeamRepository teamRepository,
//                             SprintCapacityService sprintCapacityService) {
//        this.teamRepository = teamRepository;
//        this.sprintCapacityService = sprintCapacityService;
//    }
//
//    @GetMapping("/{requestedTeamName}")
//    private ResponseEntity<Team> findById(@PathVariable String requestedTeamName) {
//        Optional<Team> teamOptional = teamRepository.findById(requestedTeamName);
//        if (teamOptional.isPresent()) {
//            return ResponseEntity.ok(teamOptional.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping
//    private ResponseEntity<Void> createTeam(@RequestBody Team newTeamRequest,
//                                                     UriComponentsBuilder ucb) {
//        Team savedTeam = teamRepository.save(newTeamRequest);
//        URI locationOfNewTeam = ucb
//                .path("team/{requestedTeamName}")
//                .buildAndExpand(savedTeam.getFirstName())
//                .toUri();
//        return ResponseEntity.created(locationOfNewTeam).build();
//    }
//
//    @PostMapping("/calculate")
//    private ResponseEntity<String> calculateSprint(@RequestBody Team newTeamRequest) {
//        String sprintCapacity = sprintCapacityService.calculate(newTeamRequest);
//        return ResponseEntity.ok(sprintCapacity);
//    }
//}
