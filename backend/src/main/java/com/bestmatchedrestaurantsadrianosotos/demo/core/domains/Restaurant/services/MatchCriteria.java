package com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.Pair;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.UseCase;

public class MatchCriteria implements UseCase<Pair<SearchCriteria, Restaurant>, Boolean> {

    @Override
    public Boolean invoke(Pair<SearchCriteria, Restaurant> input) {
        SearchCriteria searchCriteria = input.getFirst();
        Restaurant restaurant = input.getSecond();

        return ((searchCriteria.getName() == null || searchCriteria.getName().isEmpty()) || restaurant.getName().toLowerCase().contains(searchCriteria.getName().toLowerCase()))
                && (searchCriteria.getCustomerRating() == 0 || restaurant.getRating() >= searchCriteria.getCustomerRating())
                && (searchCriteria.getDistance() == 0 || restaurant.getDistance() <= searchCriteria.getDistance())
                && (searchCriteria.getPrice() == 0 || restaurant.getAveragePrice() <= searchCriteria.getPrice())
                && ((searchCriteria.getCuisine() == null || searchCriteria.getCuisine().isEmpty()) || restaurant.getCuisine().toLowerCase().contains(searchCriteria.getCuisine().toLowerCase()));
    }
}
