package com.casechek.sprint_tools.api;

import com.casechek.sprint_tools.persistence.SprintCalculatorRepository;
import com.casechek.sprint_tools.persistence.entity.CapacityCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import java.net.URI;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/capacitycalcs")
class CapacityCalcController {
    private final SprintCalculatorRepository sprintCalculatorRepository;

    private CapacityCalcController(SprintCalculatorRepository sprintCalculatorRepository) {
        this.sprintCalculatorRepository = sprintCalculatorRepository;
    }

    @GetMapping("/{requestedTeamName}")
    private ResponseEntity<CapacityCalculator> findById(@PathVariable String requestedTeamName) {
        Optional<CapacityCalculator> capacityCalculatorOptional = sprintCalculatorRepository.findById(requestedTeamName);
        if (capacityCalculatorOptional.isPresent()) {
            return ResponseEntity.ok(capacityCalculatorOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createCapacityCalculator(@RequestBody CapacityCalculator newCapacityCalculatorRequest,
                                                     UriComponentsBuilder ucb) {
        CapacityCalculator savedCapacityCalculator = sprintCalculatorRepository.save(newCapacityCalculatorRequest);
        URI locationOfNewCapacityCalculator = ucb
                .path("capacitycalcs/{requestedTeamName}")
                .buildAndExpand(savedCapacityCalculator.getTeamName())
                .toUri();
        return ResponseEntity.created(locationOfNewCapacityCalculator).build();
    }
}
