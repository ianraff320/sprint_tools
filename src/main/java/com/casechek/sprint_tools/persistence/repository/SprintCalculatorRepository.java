package com.casechek.sprint_tools.persistence.repository;

import com.casechek.sprint_tools.persistence.entity.CapacityCalculator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SprintCalculatorRepository extends CrudRepository<CapacityCalculator, String> {
}
