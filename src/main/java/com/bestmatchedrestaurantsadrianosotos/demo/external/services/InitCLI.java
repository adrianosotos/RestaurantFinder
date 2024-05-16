package com.bestmatchedrestaurantsadrianosotos.demo.external.services;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class InitCLI {
    private final Scanner scanner;
    private final ReadIntInput readIntInput;
    private final ReadStringInput readStringInput;
    private final PrintRestaurantTable printRestaurantTable;
    private final GetRestaurants getRestaurants;

    @Autowired
    public InitCLI(
            Scanner scanner,
            ReadIntInput readIntInput,
            ReadStringInput readStringInput,
            PrintRestaurantTable printRestaurantTable,
            GetRestaurants getRestaurants
    )  {
        this.scanner = scanner;
        this.readIntInput = readIntInput;
        this.readStringInput = readStringInput;
        this.printRestaurantTable =  printRestaurantTable;
        this.getRestaurants = getRestaurants;
    }

    public void init() {
        try {
            System.out.println("\nWelcome to Restaurant Finder!\n");
            System.out.println("\nPlease, type your criteria:\n");

            do {
                String name = readStringInput.readLine("Restaurant Name: ");
                int rating = readIntInput.readInt("Rating (1 - 5 stars): ");
                int distance = readIntInput.readInt("Max distance: ");
                String cuisine = readStringInput.readLine("Cuisine: ");
                int price = readIntInput.readInt("Price: ");

                List<Restaurant> restaurants = getRestaurants.find(rating, distance, price, cuisine, name);

                if (restaurants.size() == 0) {
                    System.out.println("\nNo matches to criteria\n");
                } else {
                    printRestaurantTable.printTable(restaurants);
                }

                System.out.println("\nDo you want to restart the application? (Y/N): ");
            } while (scanner.nextLine().equalsIgnoreCase("Y"));

            System.out.println("Thank you for using Restaurant Finder. Goodbye!");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
