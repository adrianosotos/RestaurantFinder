package com.bestmatchedrestaurantsadrianosotos.demo.external.services;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.FindRestaurants;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.SortRestaurants;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRestaurants {
    private final SelectNthRestaurants selectNthRestaurants;
    private final FindRestaurants findRestaurants;
    private final SortRestaurants sortRestaurants;

    @Autowired
    public GetRestaurants(SelectNthRestaurants selectNthRestaurants, FindRestaurants findRestaurants, SortRestaurants sortRestaurants) {
        this.selectNthRestaurants = selectNthRestaurants;
        this.findRestaurants = findRestaurants;
        this.sortRestaurants = sortRestaurants;
    }

    public List<Restaurant> find(int customerRating, int distance, int price, String cuisine, String name) {
        SearchCriteria query = createCriteria(customerRating, distance, price, cuisine, name);

        List<Restaurant> restaurants = findRestaurants.invoke(query);
        List<Restaurant> sortedRestaurants = sortRestaurants.invoke(restaurants);

        return selectNthRestaurants.getList(sortedRestaurants, 5);
    }

    public SearchCriteria createCriteria(int customerRating, int distance, int price, String cuisine, String name) {
        SearchCriteria query = new SearchCriteria();

        query.setName(name);
        query.setDistance(distance);
        query.setCuisine(cuisine);
        query.setPrice(price);
        query.setCustomerRating(customerRating);

        return query;
    }
}
