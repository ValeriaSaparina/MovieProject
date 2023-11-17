package com.example.movieproject.models;

import java.sql.Date;

public class Director extends Person {
    public Director(long id, String firstname, String lastname, String gender, String photoPath, Date dateOfBirth) {
        super(id, firstname, lastname, gender, photoPath, dateOfBirth);
    }
}
