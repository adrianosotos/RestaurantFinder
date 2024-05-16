package com.bestmatchedrestaurantsadrianosotos.demo.core.ports;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;

import java.util.List;

public interface Repository {
    List<Restaurant> getRestaurantsByCriteria(SearchCriteria searchCriteria);
}
