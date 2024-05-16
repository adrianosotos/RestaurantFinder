package com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services;
import com.bestmatchedrestaurantsadrianosotos.demo.TestUtils.TestUtils;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchCriteriaTest {

    @Test
    public void testMatchCriteria_AllCriteriaMatch() {
        SearchCriteria criteria = TestUtils.createSearchCriteria("Pizza", 4, 2, 20, "Italian");
        Restaurant restaurant = TestUtils.createRestaurant("Pizza Palace", 4, 1, 15, "Italian");

        Pair<SearchCriteria, Restaurant> input = new Pair(criteria, restaurant);
        MatchCriteria matchCriteria = new MatchCriteria();

        boolean result = matchCriteria.invoke(input);

        assertTrue(result, "All criteria should match");
    }

    @Test
    public void testMatchCriteria_NoCriteriaSet() {
        SearchCriteria criteria = new SearchCriteria(); // No criteria set
        Restaurant restaurant = TestUtils.createRestaurant("Any Restaurant", 3, 2, 30, "French");

        Pair<SearchCriteria, Restaurant> input = new Pair(criteria, restaurant);
        MatchCriteria matchCriteria = new MatchCriteria();

        boolean result = matchCriteria.invoke(input);

        assertTrue(result, "No criteria set should match all restaurants");
    }

    @Test
    public void testMatchCriteria_NameMismatch() {
        SearchCriteria criteria = TestUtils.createSearchCriteria("Burger King", 0, 0, 0, "");
        Restaurant restaurant = TestUtils.createRestaurant("Pizza Palace", 4, 1, 15, "Italian");

        Pair<SearchCriteria, Restaurant> input = new Pair(criteria, restaurant);
        MatchCriteria matchCriteria = new MatchCriteria();

        boolean result = matchCriteria.invoke(input);

        assertFalse(result, "Restaurant name should not match");
    }

    @Test
    public void testMatchCriteria_RatingBelowCriteria() {
        SearchCriteria criteria = TestUtils.createSearchCriteria("", 4, 0, 0, "");
        Restaurant restaurant = TestUtils.createRestaurant("Any Restaurant", 3, 2, 30, "French");

        Pair<SearchCriteria, Restaurant> input = new Pair(criteria, restaurant);
        MatchCriteria matchCriteria = new MatchCriteria();

        boolean result = matchCriteria.invoke(input);

        assertFalse(result, "Restaurant rating should be below criteria");
    }

    @Test
    public void testMatchCriteria_RatingCriteria() {
        SearchCriteria criteria = TestUtils.createSearchCriteria("", 2, 0, 0, "");
        Restaurant restaurant = TestUtils.createRestaurant("Any Restaurant", 5, 2, 30, "French");

        Pair<SearchCriteria, Restaurant> input = new Pair(criteria, restaurant);
        MatchCriteria matchCriteria = new MatchCriteria();

        boolean result = matchCriteria.invoke(input);

        System.out.println(result);

        assertTrue(result, "should return restaurants with greater value");
    }

    @Test
    public void testMatchCriteria_DistanceAboveCriteria() {
        SearchCriteria criteria = TestUtils.createSearchCriteria("", 0, 1, 0, "");
        Restaurant restaurant = TestUtils.createRestaurant("Any Restaurant", 3, 2, 30, "French");

        Pair<SearchCriteria, Restaurant> input = new Pair(criteria, restaurant);
        MatchCriteria matchCriteria = new MatchCriteria();

        boolean result = matchCriteria.invoke(input);

        assertFalse(result, "Restaurant distance should be above criteria");
    }

    @Test
    public void testMatchCriteria_PriceAboveCriteria() {
        SearchCriteria criteria = TestUtils.createSearchCriteria("", 0, 0, 15, "");
        Restaurant restaurant = TestUtils.createRestaurant("Any Restaurant", 3, 2, 30, "French");

        Pair<SearchCriteria, Restaurant> input = new Pair(criteria, restaurant);
        MatchCriteria matchCriteria = new MatchCriteria();

        boolean result = matchCriteria.invoke(input);

        assertFalse(result, "Restaurant price should be above criteria");
    }

    @Test
    public void testMatchCriteria_CuisineMismatch() {
        SearchCriteria criteria = TestUtils.createSearchCriteria("", 0, 0, 0, "Mexican");
        Restaurant restaurant = TestUtils.createRestaurant("Any Restaurant", 3, 2, 30, "French");

        Pair<SearchCriteria, Restaurant> input = new Pair(criteria, restaurant);
        MatchCriteria matchCriteria = new MatchCriteria();

        boolean result = matchCriteria.invoke(input);

        assertFalse(result, "Restaurant cuisine should not match");
    }
}

