package com.bestmatchedrestaurantsadrianosotos.demo.external.services;

import com.bestmatchedrestaurantsadrianosotos.demo.TestUtils.TestUtils;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.FindRestaurants;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.SortRestaurants;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GetRestaurantsTest {
    private GetRestaurants getRestaurants;

    @Mock
    SelectNthRestaurants selectNthRestaurants;

    @Mock
    FindRestaurants findRestaurants;

    @Mock
    SortRestaurants sortRestaurants;

    @BeforeEach
    public void setUp() {
        getRestaurants = new GetRestaurants(selectNthRestaurants, findRestaurants, sortRestaurants);
    }

    @Test
    public void testFindRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(TestUtils.createRestaurant("teste", 1, 1, 1, "Italian"));
        Mockito.when(findRestaurants.invoke(Mockito.any())).thenReturn(restaurants);
        Mockito.when(sortRestaurants.invoke(Mockito.any())).thenReturn(restaurants);
        Mockito.when(selectNthRestaurants.getList(Mockito.anyList(), Mockito.anyInt())).thenReturn((restaurants));


        List<Restaurant> result = getRestaurants.find(1, 1, 1, "Italian", "teste");

        assertEquals(restaurants, result);
    }

    @Test
    public void testCreateCriteria() {
        int customerRating = 5;
        int distance = 10;
        int price = 20;
        String cuisine = "Italian";
        String name = "Test Restaurant";

        SearchCriteria criteria = getRestaurants.createCriteria(customerRating, distance, price, cuisine, name);

        assertEquals(name, criteria.getName());
        assertEquals(customerRating, criteria.getCustomerRating());
        assertEquals(distance, criteria.getDistance());
        assertEquals(cuisine, criteria.getCuisine());
        assertEquals(price, criteria.getPrice());
    }
}
