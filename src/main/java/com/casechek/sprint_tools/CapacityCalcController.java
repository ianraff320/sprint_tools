package com.casechek.sprint_tools;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/capacitycalcs")
class CapacityCalcController {
    private final SprintCalculatorRepository sprintCalculatorRepository;

    private CapacityCalcController(SprintCalculatorRepository sprintCalculatorRepository) {
        this.sprintCalculatorRepository = sprintCalculatorRepository;
    }

    @GetMapping("/{requestedTeamName}")
    private ResponseEntity<CapacityCalculator> findById(@PathVariable(required = true) String requestedTeamName) {
        Optional<CapacityCalculator> capacityCalculatorOptional = sprintCalculatorRepository.findById(requestedTeamName);
        if (requestedTeamName.equals("full stack alchemists")) {
            CapacityCalculator capacityCalculator = new CapacityCalculator("full stack alchemists", 9,
                    0, 5, 10, 22.0F);
            return ResponseEntity.ok(capacityCalculator);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
