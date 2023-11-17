package com.example.movieproject.models;

import java.util.ArrayList;
import java.sql.Date;

public class User extends Person {


    private String username;
    private String password;

    private String bio;

    private ArrayList<String> favoriteGenres; //TODO: ArrayList<Genres>

    public User(long id, String username, String password, String name, String surname,
                Date dateOfBirth, String gender, String pathPhoto, String bio) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = name;
        this.lastname = surname;
        this.gender = gender;
        this.photoPath = pathPhoto;
        this.bio = bio;
//        this.favoriteGenres = favoriteGenres;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(long id, String username, String password, String name, String surname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = name;
        this.lastname = surname;
    }

    public User(String username, String name, String surname, String password) {
        this.username = username;
        this.firstname = name;
        this.lastname = surname;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(ArrayList<String> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
