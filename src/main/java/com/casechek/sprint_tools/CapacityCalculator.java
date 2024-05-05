package com.casechek.sprint_tools;

import org.springframework.data.annotation.Id;

record CapacityCalculator(@Id String teamName, Integer daysInSprint, Integer holidays, Integer developerCount,
                          Integer ptoTotal, Float averageVelocity) {
}