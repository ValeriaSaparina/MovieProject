package com.example.movieproject.models;

import java.sql.Date;

// specify the table name
public class Award {
    public Award(Long id, String awardName, String awardCategory, Date dateFoundation, String awardedLocation, String history, String founder, String otherDetails) {
        this.id = id;
        this.awardName = awardName;
        this.awardCategory = awardCategory;
        this.dateFoundation = dateFoundation;
        this.awardedLocation = awardedLocation;
        this.history = history;
        this.founder = founder;
        this.otherDetails = otherDetails;
    }

    private Long id;

    private String awardName;
    private String awardCategory;
    private Date dateFoundation;
    private String awardedLocation;
    private String history;
    private String founder;
    private String otherDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardCategory() {
        return awardCategory;
    }

    public void setAwardCategory(String awardCategory) {
        this.awardCategory = awardCategory;
    }

    public Date getDateFoundation() {
        return dateFoundation;
    }

    public void setDateFoundation(Date dateFoundation) {
        this.dateFoundation = dateFoundation;
    }

    public String getAwardedLocation() {
        return awardedLocation;
    }

    public void setAwardedLocation(String awardedLocation) {
        this.awardedLocation = awardedLocation;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}
