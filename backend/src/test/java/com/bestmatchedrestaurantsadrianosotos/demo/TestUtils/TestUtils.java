package com.bestmatchedrestaurantsadrianosotos.demo.TestUtils;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;

public class TestUtils {
    public static Restaurant createRestaurant(String name, int customerRating, int distance, int price, String cuisine) {
        Restaurant restaurant = new Restaurant();

        restaurant.setRating(customerRating);
        restaurant.setDistance(distance);
        restaurant.setAveragePrice(price);
        restaurant.setCuisine(cuisine);
        restaurant.setName(name);

        return restaurant;
    }

    public static SearchCriteria createSearchCriteria(String name, int customerRating, int distance, int price, String cuisine) {
        SearchCriteria criteria = new SearchCriteria();

        criteria.setName(name);
        criteria.setCustomerRating(customerRating);
        criteria.setDistance(distance);
        criteria.setPrice(price);
        criteria.setCuisine(cuisine);

        return criteria;
    }
}
