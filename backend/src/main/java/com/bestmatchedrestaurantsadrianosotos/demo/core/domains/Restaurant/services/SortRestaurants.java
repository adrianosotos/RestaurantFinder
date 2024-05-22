package com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.RestaurantComparator;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.UseCase;

import java.util.Collections;
import java.util.List;

public class SortRestaurants implements UseCase<List<Restaurant>, List<Restaurant>> {
    @Override
    public List<Restaurant> invoke(List<Restaurant> restaurants) {
        RestaurantComparator comparator = new RestaurantComparator();

        Collections.sort(restaurants, comparator);

        return restaurants;
    }
}
