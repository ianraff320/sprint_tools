package com.casechek.sprint_tools.api;

import com.casechek.sprint_tools.persistence.entity.Developer;
import com.casechek.sprint_tools.persistence.entity.Team;
import com.casechek.sprint_tools.persistence.repository.DeveloperRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/developers")
class DeveloperController {
    private final DeveloperRepository developerRepository;


    private DeveloperController(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Developer> findById(@PathVariable("id") Long requestedId) {
        Optional<Developer> developerOptional = developerRepository.findById(requestedId);
        if (developerOptional.isPresent()) {
            return ResponseEntity.ok(developerOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Developer> createDeveloper(@RequestBody Developer newDeveloperRequest) {
        Developer savedDeveloper = developerRepository.save(newDeveloperRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeveloper);
    }
}
