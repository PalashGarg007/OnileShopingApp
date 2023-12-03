package com.genpact.onlineshopingapp.entity;

public class Review {
private Integer id;
private Double rating;
private String review;


    public Review() {
    }

    public Review(Integer id, Double rating, String review) {
        this.id = id;
        this.rating = rating;
        this.review = review;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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
