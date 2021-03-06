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

    public Movie () {}

    public Movie (int id, String title, String year, String rated, String genre, String actors) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.genre = genre;
        this.actors = actors;
    }

    public Movie (String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public Movie (String title) {
        this.title = title;
    }

    public int getId() { return id; }

    private void setId(int id) { this.id = id; }

    public String getTitle() {return this.title;}

    public void setTitle(String titles) {
        title = title.concat(titles);
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

    public String getGenre() { return this.genre; }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    private void setActors(String actors) {
        this.actors = actors;
    }

}
