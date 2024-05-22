package com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.ports.Repository;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.UseCase;

import java.util.List;

public class FindRestaurants implements UseCase<SearchCriteria, List<Restaurant>> {
    private Repository repository;

    public FindRestaurants(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<Restaurant> invoke(SearchCriteria searchCriteria) {
        try {
            if (searchCriteria.checkAllValuesEmpty()) {
                throw new Error("Invalid criteria");
            }

            return this.repository.getRestaurantsByCriteria(searchCriteria);
        } catch (Error error) {
            throw error;
        }
    }
}
