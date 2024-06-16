package com.casechek.sprint_tools.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sprint")
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String teamName; // this shouldn't be here because it's built elsewhere?
    Date startDate;
    Date endDate;
    Integer holidays;
    Integer ptoTotal;
    Integer estimatedPoints;
    Integer completedPoints;

    public Sprint() {
    }

    public Sprint(Long id, String name, String teamName, Date startDate, Date endDate, Integer holidays, Integer ptoTotal) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.holidays = holidays;
        this.ptoTotal = ptoTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getHolidays() {
        return holidays;
    }

    public void setHolidays(Integer holidays) {
        this.holidays = holidays;
    }

    public Integer getPtoTotal() {
        return ptoTotal;
    }

    public void setPtoTotal(Integer ptoTotal) {
        this.ptoTotal = ptoTotal;
    }

    public Integer getEstimatedPoints() {
        return estimatedPoints;
    }

    public void setEstimatedPoints(Integer estimatedPoints) {
        this.estimatedPoints = estimatedPoints;
    }

    public Integer getCompletedPoints() {
        return completedPoints;
    }

    public void setCompletedPoints(Integer completedPoints) {
        this.completedPoints = completedPoints;
    }
}

