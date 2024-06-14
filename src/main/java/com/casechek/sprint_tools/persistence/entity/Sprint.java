package com.casechek.sprint_tools.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "capacity_calculator")
public class Sprint {

    @Id
    Long id;
    String sprintName;
    String teamName; // this shouldn't be here because it's built elsewhere?
    Date startDate;
    Date endDate;
    Integer holidays;
    Integer ptoTotal;
    Float averageVelocity;

    public Sprint() {
    }

    public Sprint(String sprintName, Integer startDate, Integer holidays, Integer developerCount, Integer ptoTotal,
                  Float averageVelocity) {
        this.sprintName = sprintName;
        this.daysInSprint = startDate;
        this.holidays = holidays;
        this.developerCount = developerCount;
        this.ptoTotal = ptoTotal;
        this.averageVelocity = averageVelocity;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public Integer getStartDate() {
        return daysInSprint;
    }

    public void setStartDate(Integer startDate) {
        this.daysInSprint = startDate;
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