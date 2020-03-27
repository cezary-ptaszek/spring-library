package com.cognifide.library.model;

public class Author {
    private String name;
    private Double rating;
    private Integer allCounter;
    private Integer currCounter;

    public Author(String name, Double rating, Integer allCounter, Integer currCounter) {
        this.name = name;
        this.rating = rating;
        this.allCounter = allCounter;
        this.currCounter = currCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getAllCounter() {
        return allCounter;
    }

    public void setAllCounter(Integer allCounter) {
        this.allCounter = allCounter;
    }

    public Integer getCurrCounter() {
        return currCounter;
    }

    public void setCurrCounter(Integer currCounter) {
        this.currCounter = currCounter;
    }
}
