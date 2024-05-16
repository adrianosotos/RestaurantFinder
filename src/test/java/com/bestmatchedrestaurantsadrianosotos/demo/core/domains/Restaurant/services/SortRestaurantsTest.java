package com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.RestaurantComparator;
import com.bestmatchedrestaurantsadrianosotos.demo.TestUtils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SortRestaurantsTest {
    RestaurantComparator comparatorMock;

    @BeforeEach
    public void setUp() {
        comparatorMock = mock(RestaurantComparator.class);
    }


    @Test
    public void sortRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant restaurantC = TestUtils.createRestaurant("Restaurant C", 4, 3, 20, "Italian");
        Restaurant restaurantA = TestUtils.createRestaurant("Restaurant A", 5, 1, 30, "Italian");
        Restaurant restaurantB = TestUtils.createRestaurant("Restaurant B", 3, 2, 25, "Chinese");

        restaurants.add(restaurantC);
        restaurants.add(restaurantA);
        restaurants.add(restaurantB);

        when(comparatorMock.compare(restaurants.get(0), restaurants.get(1))).thenReturn(-1);
        when(comparatorMock.compare(restaurants.get(0), restaurants.get(2))).thenReturn(1);
        when(comparatorMock.compare(restaurants.get(1), restaurants.get(2))).thenReturn(1);

        SortRestaurants sortRestaurants = new SortRestaurants();
        List<Restaurant> sortedRestaurants = sortRestaurants.invoke(restaurants);

        List<Restaurant> expectedSortedRestaurants = new ArrayList<>();
        expectedSortedRestaurants.add(restaurantA);
        expectedSortedRestaurants.add(restaurantB);
        expectedSortedRestaurants.add(restaurantC);

        assertEquals(expectedSortedRestaurants, sortedRestaurants);
    }
}
