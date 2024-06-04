package com.casechek.sprint_tools.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "capacity_calculator")
public class CapacityCalculator {

    @Id
    String teamName;
    Integer daysInSprint;
    Integer holidays;
    Integer developerCount;
    Integer ptoTotal;
    Float averageVelocity;

    public CapacityCalculator() {
    }

    public CapacityCalculator(String teamName, Integer daysInSprint, Integer holidays, Integer developerCount, Integer ptoTotal, Float averageVelocity) {
        this.teamName = teamName;
        this.daysInSprint = daysInSprint;
        this.holidays = holidays;
        this.developerCount = developerCount;
        this.ptoTotal = ptoTotal;
        this.averageVelocity = averageVelocity;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getDaysInSprint() {
        return daysInSprint;
    }

    public void setDaysInSprint(Integer daysInSprint) {
        this.daysInSprint = daysInSprint;
    }

    public Integer getHolidays() {
        return holidays;
    }

    public void setHolidays(Integer holidays) {
        this.holidays = holidays;
    }

    public Integer getDeveloperCount() {
        return developerCount;
    }

    public void setDeveloperCount(Integer developerCount) {
        this.developerCount = developerCount;
    }

    public Integer getPtoTotal() {
        return ptoTotal;
    }

    public void setPtoTotal(Integer ptoTotal) {
        this.ptoTotal = ptoTotal;
    }

    public Float getAverageVelocity() {
        return averageVelocity;
    }

    public void setAverageVelocity(Float averageVelocity) {
        this.averageVelocity = averageVelocity;
    }
}