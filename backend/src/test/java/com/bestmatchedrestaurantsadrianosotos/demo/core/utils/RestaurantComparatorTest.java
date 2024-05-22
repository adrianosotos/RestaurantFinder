package com.bestmatchedrestaurantsadrianosotos.demo.core.utils;

import com.bestmatchedrestaurantsadrianosotos.demo.TestUtils.TestUtils;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantComparatorTest {

    @Test
    public void sortByDistance() {
        Restaurant restaurantA = TestUtils.createRestaurant("restaurantA", 1, 5, 10, "usa");
        Restaurant restaurantB = TestUtils.createRestaurant("restaurantB", 1, 10, 10, "usa");

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurantA);
        restaurants.add(restaurantB);

        RestaurantComparator comparator = new RestaurantComparator();

        Collections.sort(restaurants, comparator);

        assertEquals(restaurantA.getName(), restaurants.get(0).getName());
        assertEquals(restaurantB.getName(), restaurants.get(1).getName());
    }

    @Test
    public void sortByRantingIfSameDistance() {
        Restaurant restaurantA = TestUtils.createRestaurant("restaurantA", 1, 10, 10, "usa");
        Restaurant restaurantB = TestUtils.createRestaurant("restaurantB", 4, 10, 10, "usa");

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurantA);
        restaurants.add(restaurantB);

        RestaurantComparator comparator = new RestaurantComparator();

        Collections.sort(restaurants, comparator);

        assertEquals(restaurantB.getName(), restaurants.get(0).getName());
        assertEquals(restaurantA.getName(), restaurants.get(1).getName());
    }

    @Test
    public void sortByPriceIfRatingAndDistanceSame() {
        Restaurant restaurantA = TestUtils.createRestaurant("restaurantA", 4, 10, 10, "usa");
        Restaurant restaurantB = TestUtils.createRestaurant("restaurantB", 4, 10, 30, "usa");
        Restaurant restaurantC = TestUtils.createRestaurant("restaurantC", 4, 10, 20, "usa");

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurantA);
        restaurants.add(restaurantB);
        restaurants.add(restaurantC);

        RestaurantComparator comparator = new RestaurantComparator();

        Collections.sort(restaurants, comparator);

        assertEquals(restaurantA.getName(), restaurants.get(0).getName());
        assertEquals(restaurantC.getName(), restaurants.get(1).getName());
        assertEquals(restaurantB.getName(), restaurants.get(2).getName());
    }

    @Test
    public void sameOrderIfSameConditions() {
        Restaurant restaurantA = TestUtils.createRestaurant("restaurantA", 4, 10, 10, "usa");
        Restaurant restaurantB = TestUtils.createRestaurant("restaurantB", 4, 10, 10, "usa");
        Restaurant restaurantC = TestUtils.createRestaurant("restaurantC", 4, 10, 10, "usa");

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurantA);
        restaurants.add(restaurantB);
        restaurants.add(restaurantC);

        RestaurantComparator comparator = new RestaurantComparator();

        Collections.sort(restaurants, comparator);

        assertEquals(restaurantA.getName(), restaurants.get(0).getName());
        assertEquals(restaurantB.getName(), restaurants.get(1).getName());
        assertEquals(restaurantC.getName(), restaurants.get(2).getName());
    }
}

