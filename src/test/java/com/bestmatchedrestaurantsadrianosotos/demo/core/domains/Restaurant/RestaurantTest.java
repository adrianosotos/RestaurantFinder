package com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest {
    @Test
    public void testRestaurantProperties() {
        Restaurant restaurant = new Restaurant();

        restaurant.setName("New Restaurante");
        restaurant.setRating(5);
        restaurant.setDistance(3);
        restaurant.setAveragePrice(40);
        restaurant.setCuisine("Italian");

        assertEquals("New Restaurante", restaurant.getName());
        assertEquals(5, restaurant.getRating());
        assertEquals(3, restaurant.getDistance());
        assertEquals(40, restaurant.getAveragePrice());
        assertEquals("Italian", restaurant.getCuisine());
    }
}
