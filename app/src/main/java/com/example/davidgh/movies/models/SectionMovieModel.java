package com.example.davidgh.movies.models;

import java.util.ArrayList;

public class SectionMovieModel {

    private String header;
    private ArrayList<SingleMovieModel> allItems;

    public SectionMovieModel(String header, ArrayList<SingleMovieModel> allItems) {
        this.header = header;
        this.allItems = allItems;
    }

    public SectionMovieModel() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ArrayList<SingleMovieModel> getAllItems() {
        return allItems;
    }

    public void setAllItems(ArrayList<SingleMovieModel> allItems) {
        this.allItems = allItems;
    }
}
