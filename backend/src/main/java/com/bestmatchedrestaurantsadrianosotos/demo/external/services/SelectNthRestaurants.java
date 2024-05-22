package com.bestmatchedrestaurantsadrianosotos.demo.external.services;

import org.springframework.stereotype.Service;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;

import java.util.List;

@Service
public class SelectNthRestaurants {
    public List<Restaurant> getList(List<Restaurant> restaurants, int n) {
        if (n <= 0) {
            throw new Error("Invalid limit value");
        }

        if (restaurants.size() > n) {
            return restaurants.subList(0, n);
        } else {
            return restaurants;
        }
    }
}
