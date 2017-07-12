package com.example.jason.flixgen;

/**
 * Created by jason on 7/7/2017.
 */

public class User {
    int _id;
    String _username;
    String _password;
    Movie userMovie = new Movie();

    public User() {}

    public User(int id, String username, String password, String title, String genre) {
        this._id = id;
        this._username = username;
        this._password = password;
        userMovie.setTitle(title);
        userMovie.setGenre(genre);
    }

    public User(int id, String username, String password) {
        this._id = id;
        this._username = username;
        this._password = password;
    }

    public User(String username, String password) {
        this._username = username;
        this._password = password;
    }


    public int getID() {
        return this._id;
    }

    public void setID(int id) {
        this._id = id;
    }

    public String getUsername() {
        return this._username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public String getPassword() {
        return this._password;
    }

    public void setPassword(String password) {
        this._password = password;
    }

    public String getMovieTitle(String title) {return userMovie.getTitle(title);}
    public String getMovieGenre(String genre) {return userMovie.getGenre(genre);}

    public void setMovieTitle(String title) {userMovie.setTitle(title);}
    public void setMovieGenre(String genre) {userMovie.setGenre(genre);}
}
