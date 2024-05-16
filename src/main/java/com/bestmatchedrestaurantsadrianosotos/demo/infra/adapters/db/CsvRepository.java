package com.bestmatchedrestaurantsadrianosotos.demo.infra.adapters.db;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.MatchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.ports.Repository;
import com.bestmatchedrestaurantsadrianosotos.demo.core.utils.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CsvRepository implements Repository  {
    HashMap<Integer, String> cuisineHashMap;
    BufferedReader brRestaurants;
    BufferedReader brCuisineCode;
    MatchCriteria matchCriteria;

    @Override
    public List<Restaurant> getRestaurantsByCriteria(SearchCriteria searchCriteria) {
        return readRestaurantsFromCSV(searchCriteria);
    }

    public CsvRepository(BufferedReader brRestaurants, BufferedReader brCuisineCode, MatchCriteria matchCriteria) throws IOException {
        this.brRestaurants = brRestaurants;
        this.brRestaurants.mark(8192);
        this.brCuisineCode = brCuisineCode;
        this.matchCriteria = matchCriteria;
        initialize();
    }

    private void initialize() {
        cuisineHashMap = getCuisineLabelsByCode();
    }

    private HashMap<Integer, String> getCuisineLabelsByCode() {
        HashMap<Integer, String> hashMap = new HashMap<>();

        try  {
            String line;
            int lineNumber = 0;
            while ((line = brCuisineCode.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 2) {
                    int id = Integer.parseInt(data[0]);
                    String label = data[1];

                    hashMap.put(id, label);

                    lineNumber++;
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return hashMap;
    }

    private List<Restaurant> readRestaurantsFromCSV(SearchCriteria searchCriteria) {
        List<Restaurant> restaurants = new ArrayList<>();
        try  {
            brRestaurants.reset();

            String line;
            int lineNumber = 0;

            while ((line = brRestaurants.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length >= 5) {
                    String name = data[0];
                    int customerRating = Integer.parseInt(data[1]);
                    int distance = Integer.parseInt(data[2]);
                    int price = Integer.parseInt(data[3]);
                    int cuisineCode = Integer.parseInt(data[4]);
                    String cuisineLabel = cuisineHashMap.get(cuisineCode);

                    Restaurant restaurant = createRestaurant(name, customerRating, distance, price, cuisineLabel);

                    if (matchCriteria.invoke(new Pair<>(searchCriteria, restaurant))) {
                        restaurants.add(restaurant);
                    }

                    lineNumber++;
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return restaurants;
    }

    private Restaurant createRestaurant (String name, int rating, int distance, int price, String cuisine) {
        Restaurant restaurant = new Restaurant();

        restaurant.setName(name);
        restaurant.setRating(rating);
        restaurant.setDistance(distance);
        restaurant.setAveragePrice(price);
        restaurant.setCuisine(cuisine);

        return restaurant;
    }
}
