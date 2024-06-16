package com.casechek.sprint_tools.api;

import com.casechek.sprint_tools.persistence.entity.Sprint;

import com.casechek.sprint_tools.persistence.repository.SprintRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sprints")
public class SprintController {
    private final SprintRepository sprintRepository;

    public SprintController(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sprint> findById(@PathVariable Long id) {
        Optional<Sprint> sprintOptional = sprintRepository.findById(id);
        if (sprintOptional.isPresent()) {
            return ResponseEntity.ok(sprintOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Sprint>> findAll() {
        List<Sprint> sprints = (List<Sprint>) sprintRepository.findAll();
        return ResponseEntity.ok(sprints);
    }

    @GetMapping("/search")
    public ResponseEntity<Sprint> findByName(@RequestParam String name) {
        Optional<Sprint> sprintOptional = sprintRepository.findByName(name);
        if (sprintOptional.isPresent()) {
            return ResponseEntity.ok(sprintOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sprint> createSprint (@RequestBody Sprint newSprintRequest) {
        Sprint savedSprint = sprintRepository.save(newSprintRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSprint);
    }

}
