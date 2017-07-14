package com.example.jason.flixgen;

import java.util.ArrayList;

/**
 * Created by jason on 7/7/2017.
 */

public class User {
    int _id;
    String _username;
    String _password;
    boolean access;
    String dna;
    String title = "";
    String genre = "";

    //ArrayList<Movie> userMovies = new ArrayList<Movie>();
    //Movie userMovie = new Movie();


    public User() {}

    public User(int id, String username, String password, String title, String genre, boolean access, String dna) {
        this._id = id;
        this._username = username;
        this._password = password;
        //userMovie.setTitle(title);
        //userMovie.setGenre(genre);
        this.title = title;
        this.genre = genre;
        this.access = access;
        this.dna = dna;
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

    public User(int id, String title) {
        this._id = id;
        this.title = title;
    }

    public User(String title) {
        this.title = title;
    }

    //Getters and Setters
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

    public void setTitle(String titles) {title = title.concat(titles);}
    public void setGenre(String genres) {genre = genre.concat(genres);}

    public String getTitle() {return this.title;}
    public String getGenre() {return this.genre;}

    //public String getMovieTitle() {return this.userMovie.getTitle();}
    //public void setMovieTitle(String title) {userMovie.setTitle(title);}

    /*public String getMovieTitle(String title) {
        int i = 0;
        for (Movie m : userMovies) {
            m.getTitle(title);
        }
        return userMovies;
    }

    public ArrayList<Movie> getMovie() {
        int i = 0;
        for (Movie m : userMovies) {
            m.getGenre();
            m.getTitle();
        }
        return userMovies;
    }

    public void setMovie(String title, String genre) {
        int i = 0;
        for (Movie m : userMovies) {
            m.setGenre(genre);
            m.setTitle(title);
        }
    }*/
    //public void setMovieTitle(ArrayList<String> titles) {userMovie.setTitle(titles);}
    //public void setMovieGenre(ArrayList<String> genres) {userMovie.setGenre(genres);}

    public boolean getAccess() {return this.access;}

    public void setAccess(boolean access) {this.access = access;}

    public String getDna() {return this.dna;}

    public void setDna(String dna) {this.dna = dna;}

    public void calcDNA() {
        //db.get
        int comedy = 0;
        int horror = 0;
        int action = 0;
        int adventure = 0;
        int romance = 0;
        int fantasy = 0;
        int scifi = 0;
        int drama = 0;
        int war = 0;
        int crime = 0;
        int musical = 0;
        int music = 0;
        int western = 0;
        int randomType = 0;


        String testMovieTitles = genre;
        String[] items = testMovieTitles.split(",");
        for(String item : items)
        {
            if(item == "Comedy")
                comedy += 1;
            else if(item == "Horror")
                horror += 1;
            else if(item == "Action")
                action += 1;
            else if(item == "Adventure")
                adventure += 1;
            else if(item == "Romance")
                romance += 1;
            else if(item == "Fantasy")
                fantasy += 1;
            else if(item == "Sc-Fi")
                scifi += 1;
            else if(item == "Drama")
                drama += 1;
            else if(item == "War")
                war += 1;
            else if(item == "Crime")
                crime += 1;
            else if(item == "Musical")
                musical += 1;
            else if(item == "Music")
                music += 1;
            else if(item == "Western")
                western += 1;
            else
                randomType += 1;
        }

        if(comedy > horror && comedy > action && comedy > adventure && comedy > romance && comedy > fantasy && comedy > scifi && comedy > drama && comedy > war && comedy > crime && comedy > musical && comedy > music) {
            if(horror > action && horror > adventure && horror > romance && horror > fantasy && horror > scifi && horror > drama && horror > war && horror > crime && horror > musical && horror > music) {
                if(action > adventure && action > romance && action > fantasy && action > scifi && action > drama && action > war && action > crime && action > musical && action > music)
                {
                    dna = "The Ghostbuster";
                }
                else
                    dna = "The Scary Movie Guy";
            }
            else if(romance > action && romance > adventure && romance > romance && romance > fantasy && romance > scifi && romance > drama && romance > war && romance > crime && romance > musical && romance > music) {
                if(action > adventure && action > romance && action > fantasy && action > scifi && action > drama && action > war && action > crime && action > musical && action > music)
                {
                    dna = "The McConaughey and Hudson Lover";
                }
                else
                    dna = "The Sandler and Barrymore Lover";
            }
            else
                dna = "The Chris Farley";
        }
        else if(action > horror && action > comedy && action > adventure && action > romance && action > fantasy && action > scifi && action > drama && action > war && action > crime && action > musical && action > music) {
            if (war > horror && war > adventure && war > romance && war > fantasy && war > scifi && war > drama && war > comedy && war > crime && war > musical && war > music) {
                if (crime > adventure && crime > romance && crime > fantasy && crime > scifi && crime > drama && crime > comedy && crime > musical && crime > music) {
                    dna = "The Godfather";
                } else
                    dna = "The Private Ryan";
            } else if (romance > action && romance > adventure && romance > romance && romance > fantasy && romance > scifi && romance > drama && romance > war && romance > crime && romance > musical && romance > music) {
                if (western > adventure && western > romance && western > fantasy && western > scifi && western > drama && western > war && western > crime && western > musical && western > music) {
                    dna = "The John Wayne";
                } else
                    dna = "The Dear John";
            } else
                dna = "The Chuck Norris";
        } else
            dna = "The General Movie Lover";
    }

}
