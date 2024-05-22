package com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchCriteriaTest {

    @Test
    public void testSetName() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setName("Test Name");
        assertEquals("Test Name", criteria.getName());
    }

    @Test
    public void testSetCustomerRating() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setCustomerRating(4);
        assertEquals(4, criteria.getCustomerRating());
    }

    @Test
    public void testSetDistance() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setDistance(10);
        assertEquals(10, criteria.getDistance());
    }

    @Test
    public void testSetPrice() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPrice(20);
        assertEquals(20, criteria.getPrice());
    }

    @Test
    public void testSetCuisine() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setCuisine("Italian");
        assertEquals("Italian", criteria.getCuisine());
    }

    @Test
    public void testCheckAllValuesEmpty() {
        SearchCriteria emptyCriteria = createCriteria("", "", 0, 0, 0);

        assertTrue(emptyCriteria.checkAllValuesEmpty());
    }

    @Test
    public void testCheckSomeValue() {
        SearchCriteria criteriaName = createCriteria("Name", "", 0, 0, 0);
        assertFalse(criteriaName.checkAllValuesEmpty());

        SearchCriteria criteriaCuisine = createCriteria("", "Italian", 0, 0, 0);
        assertFalse(criteriaCuisine.checkAllValuesEmpty());

        SearchCriteria criteriaDistance = createCriteria("", "", 1, 0, 0);
        assertFalse(criteriaDistance.checkAllValuesEmpty());

        SearchCriteria criteriaPrice = createCriteria("", "", 0, 1, 0);
        assertFalse(criteriaPrice.checkAllValuesEmpty());

        SearchCriteria criteriaRating = createCriteria("", "", 0, 0, 1);
        assertFalse(criteriaRating.checkAllValuesEmpty());
    }

    private SearchCriteria createCriteria(String name, String cuisine, int distance, int price, int rating) {
        SearchCriteria criteria = new SearchCriteria();

        criteria.setName(name);
        criteria.setCuisine(cuisine);
        criteria.setDistance(distance);
        criteria.setPrice(price);
        criteria.setCustomerRating(rating);

        return criteria;
    }
}
