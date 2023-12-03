package com.genpact.onlineshopingapp.entity;

public class Review {
private int id;
private Double rating;
private String review;


    public Review(int id, Double rating, String review) {
        this.id = id;
        this.rating = rating;
        this.review = review;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", rating='" + getRating() + "'" +
            ", review='" + getReview() + "'" +
            "}";
    }

}
