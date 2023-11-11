package org.example;

public class Movie {

    private String title;
    private Boolean isRated;
    private Integer rating;
    private Integer length;

    public Movie(String title, Boolean isRated, Integer rating, Integer length) {
        this.title = title;
        this.isRated = isRated;
        this.rating = rating;
        this.length = length;
    }


    //Getter

    public String getTitle() {
        return title;
    }

    public Boolean getIsRated() {
        return isRated;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getLength() {
        return length;
    }


    //Setter

    public void setIsRated(Boolean rated) {
        isRated = rated;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }


    //Methods










}
