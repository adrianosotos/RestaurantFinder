package com.bestmatchedrestaurantsadrianosotos.demo.external.api;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.external.services.GetRestaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantMatcherController {
    private GetRestaurants getRestaurants;

    @Autowired
    public RestaurantMatcherController(GetRestaurants getRestaurants) {
        this.getRestaurants = getRestaurants;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/fetchRestaurants")
    public List<Restaurant> fetchRestaurants(@RequestBody SearchCriteria searchCriteria) {
        return getRestaurants.find(
                searchCriteria.getCustomerRating(),
                searchCriteria.getDistance(),
                searchCriteria.getPrice(),
                searchCriteria.getCuisine(),
                searchCriteria.getName()
        );
    }
}
