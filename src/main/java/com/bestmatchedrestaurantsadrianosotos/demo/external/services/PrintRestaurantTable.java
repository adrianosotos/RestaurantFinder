package com.bestmatchedrestaurantsadrianosotos.demo.external.services;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintRestaurantTable {
    String spacement = "| %-30s | %-10s | %-10s | %-15s | %-20s |\n";

    public void printTable(List<Restaurant> restaurants) {
        printHeader();
        printContents(restaurants);
        printLine();
    }

    private void printHeader() {
        printLine();
        System.out.printf(spacement, "Name", "Rating", "Distance", "Average Price", "Cuisine");
        printLine();
    }

    private void printContents(List<Restaurant> restaurants) {
        for (Restaurant restaurant : restaurants) {
            System.out.printf(spacement,
                    restaurant.getName(), restaurant.getRating(), restaurant.getDistance(),
                    restaurant.getAveragePrice(), restaurant.getCuisine());
        }
    }

    private void printLine() {
         System.out.println("-----------------------------------------------------------------------------------------------------");
    }

}
