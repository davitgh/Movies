package com.example.davidgh.movies.models;

public class SingleMovieModel {
    private int id;
    private String name;
    private String url;
    private String date;
    private float rating;

    public SingleMovieModel() {
    }

    public SingleMovieModel(int id, String name, String url, String date, float rating) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.date = date;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
