package com.bestmatchedrestaurantsadrianosotos.demo.core.utils;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;

import java.util.Comparator;

public class RestaurantComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant restaurant1, Restaurant restaurant2) {
        int distanceComparison = Integer.compare(restaurant1.getDistance(), restaurant2.getDistance());
        if (distanceComparison != 0) {
            return distanceComparison;
        }

        int ratingComparison = Integer.compare(restaurant2.getRating(), restaurant1.getRating());
        if (ratingComparison != 0) {
            return ratingComparison;
        }

        int priceComparison = Integer.compare(restaurant1.getAveragePrice(), restaurant2.getAveragePrice());
        if (priceComparison != 0) {
            return priceComparison;
        }

        return 0;
    }
}

