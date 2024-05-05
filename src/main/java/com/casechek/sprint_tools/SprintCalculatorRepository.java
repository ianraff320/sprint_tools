package com.casechek.sprint_tools;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SprintCalculatorRepository extends CrudRepository<CapacityCalculator, String> {
}
