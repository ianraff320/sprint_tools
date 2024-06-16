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
public class DeveloperController {
    private final DeveloperRepository developerRepository;

    public DeveloperController(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> findById(@PathVariable Long id) {
        Optional<Developer> developerOptional = developerRepository.findById(id);
        if (developerOptional.isPresent()) {
            return ResponseEntity.ok(developerOptional.get());
        } else {
        return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer newDeveloperRequest) {
        Developer savedDeveloper = developerRepository.save(newDeveloperRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeveloper);
    }
}
