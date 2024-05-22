package com.bestmatchedrestaurantsadrianosotos.demo.infra.adapters.db;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.MatchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CsvRepositoryTest {

    @Mock
    private BufferedReader brRestaurants;

    @Mock
    private BufferedReader brCuisineCode;

    @Mock
    private SearchCriteria searchCriteria;

    @Mock
    private MatchCriteria matchCriteria;

    private CsvRepository csvRepository;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        csvRepository = new CsvRepository(brRestaurants, brCuisineCode, matchCriteria);
    }

    @Test
    public void testGetRestaurantsByCriteriaWithoutCriteria() throws IOException {
        when(brRestaurants.readLine())
                .thenReturn("name,customerRating,distance,price,cuisineCode")
                .thenReturn("Test Restaurant,5,10,20,1")
                .thenReturn(null);


        when(matchCriteria.invoke(any(Pair.class))).thenReturn(true);

        List<Restaurant> restaurants = csvRepository.getRestaurantsByCriteria(searchCriteria);

        assertEquals(1, restaurants.size());

        Restaurant restaurant = restaurants.get(0);
        assertEquals("Test Restaurant", restaurant.getName());
        assertEquals(5, restaurant.getRating());
        assertEquals(10, restaurant.getDistance());
        assertEquals(20, restaurant.getAveragePrice());
    }

    @Test
    public void testGetRestaurantsByCriteriaWithCriteria() throws IOException {
        when(brRestaurants.readLine())
                .thenReturn("name,customerRating,distance,price,cuisineCode")
                .thenReturn("Test Restaurant,5,10,20,1")
                .thenReturn(null);


        when(matchCriteria.invoke(any(Pair.class))).thenReturn(true);

        searchCriteria.setName("Test Restaurant");

        List<Restaurant> restaurants = csvRepository.getRestaurantsByCriteria(searchCriteria);

        assertEquals(1, restaurants.size());

        Restaurant restaurant = restaurants.get(0);
        assertEquals("Test Restaurant", restaurant.getName());
        assertEquals(5, restaurant.getRating());
        assertEquals(10, restaurant.getDistance());
        assertEquals(20, restaurant.getAveragePrice());
    }
}
