package com.example.jason.flixgen;

/**
 * Created by jason on 7/3/2017.
 */

public class Movie {
    public int id;
    public String title;
    public String year;
    public String rated;
    public String genre;
    public String actors;

    public Movie (int id, String title, String year, String rated, String genre, String actors) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.genre = genre;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    private void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    private void setRated(String rated) {
        this.rated = rated;
    }

    public String getGenre() {
        return genre;
    }

    private void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    private void setActors(String actors) {
        this.actors = actors;
    }

}
