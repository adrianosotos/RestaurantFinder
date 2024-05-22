package com.bestmatchedrestaurantsadrianosotos.demo.external.api;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.external.services.GetRestaurants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestaurantMatcherControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GetRestaurants getRestaurants;

    @InjectMocks
    private RestaurantMatcherController restaurantMatcherController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(restaurantMatcherController).build();
    }

    @Test
    public void testFetchRestaurants() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");
        List<Restaurant> restaurants = Arrays.asList(restaurant);
        when(getRestaurants.find(anyInt(), anyInt(), anyInt(), anyString(), anyString())).thenReturn(restaurants);

        String searchCriteriaJson = "{"
                + "\"customerRating\": 4,"
                + "\"distance\": 5,"
                + "\"price\": 20,"
                + "\"cuisine\": \"Italian\","
                + "\"name\": \"Test Restaurant\""
                + "}";

        mockMvc.perform(post("/api/fetchRestaurants")
            .contentType(MediaType.APPLICATION_JSON)
            .content(searchCriteriaJson))
            .andExpect(status().isOk())
            .andExpect(content().json("[{'name': 'Test Restaurant'}]"));
    }
}
