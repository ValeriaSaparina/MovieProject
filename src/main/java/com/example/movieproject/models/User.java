package com.example.movieproject.models;

import java.util.ArrayList;

public class User extends Person {


    private String login;
    private String password;

    private ArrayList<String> favoriteGenres; //TODO: ArrayList<Genres>

    public User(long id, String login, String password, String name, String surname,
                String gender, String pathPhoto, ArrayList<String> favoriteGenres) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.pathPhoto = pathPhoto;
        this.favoriteGenres = favoriteGenres;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
