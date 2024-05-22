package com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria;

public class SearchCriteria {
    private int customerRating;
    private int distance;
    private int price;
    private String cuisine;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(int customerRating) {
        this.customerRating = customerRating;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public boolean checkAllValuesEmpty() {
        return name.isEmpty() && cuisine.isEmpty() && customerRating == 0 && distance == 0 && price == 0;
    }
}
