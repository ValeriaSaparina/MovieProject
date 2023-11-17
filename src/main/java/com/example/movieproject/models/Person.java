package com.example.movieproject.models;

import java.sql.Date;

public class Person {
    protected long id;
    protected String firstname;
    protected String lastname;
    protected String gender;
    protected String photoPath;
    protected Date dateOfBirth;

    public Person(long id, String firstname, String lastname, String gender, String photoPath, Date dateOfBirth) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.photoPath = photoPath;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
