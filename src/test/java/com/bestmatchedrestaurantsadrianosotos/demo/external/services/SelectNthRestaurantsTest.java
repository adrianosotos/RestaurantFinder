package com.bestmatchedrestaurantsadrianosotos.demo.external.services;

import com.bestmatchedrestaurantsadrianosotos.demo.TestUtils.TestUtils;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SelectNthRestaurantsTest {

    @Test
    public void testGetListWithValidN() {
        SelectNthRestaurants selectNthRestaurants = new SelectNthRestaurants();
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(TestUtils.createRestaurant("Restaurant 1", 4, 2, 30, "Italian"));
        restaurants.add(TestUtils.createRestaurant("Restaurant 2", 4, 3, 25, "Japanese"));
        restaurants.add(TestUtils.createRestaurant("Restaurant 3", 4, 5, 35, "Mexican"));
        int n = 2;

        List<Restaurant> selectedRestaurants = selectNthRestaurants.getList(restaurants, n);

        assertEquals(2, selectedRestaurants.size());
        assertEquals("Restaurant 1", selectedRestaurants.get(0).getName());
        assertEquals("Restaurant 2", selectedRestaurants.get(1).getName());
    }

    @Test
    public void testGetListWithNEqualZero() {
        SelectNthRestaurants selectNthRestaurants = new SelectNthRestaurants();
        List<Restaurant> restaurants = new ArrayList<>();
        int n = 0;

        assertThrows(Error.class, () -> selectNthRestaurants.getList(restaurants, n));
    }

    @Test
    public void testGetListWithNGreaterThanSize() {
        SelectNthRestaurants selectNthRestaurants = new SelectNthRestaurants();
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(TestUtils.createRestaurant("Restaurant 1", 4, 2, 30, "Italian"));
        restaurants.add(TestUtils.createRestaurant("Restaurant 2", 4, 3, 25, "Japanese"));
        int n = 5;

        List<Restaurant> selectedRestaurants = selectNthRestaurants.getList(restaurants, n);

        assertEquals(2, selectedRestaurants.size());
        assertEquals("Restaurant 1", selectedRestaurants.get(0).getName());
        assertEquals("Restaurant 2", selectedRestaurants.get(1).getName());
    }
}
