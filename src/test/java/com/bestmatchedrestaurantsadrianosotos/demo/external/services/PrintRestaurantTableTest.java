package com.bestmatchedrestaurantsadrianosotos.demo.external.services;

import com.bestmatchedrestaurantsadrianosotos.demo.TestUtils.TestUtils;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintRestaurantTableTest {

    private final PrintRestaurantTable printRestaurantTable = new PrintRestaurantTable();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintTable() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(TestUtils.createRestaurant("Restaurant A", 4, 3, 25, "Italian"));
        restaurants.add(TestUtils.createRestaurant("Restaurant B", 4, 5, 30, "French"));

        printRestaurantTable.printTable(restaurants);

        String expectedOutput = "-----------------------------------------------------------------------------------------------------\n" +
                "| Name                           | Rating     | Distance   | Average Price   | Cuisine              |\n" +
                "-----------------------------------------------------------------------------------------------------\n" +
                "| Restaurant A                   | 4          | 3          | 25              | Italian              |\n" +
                "| Restaurant B                   | 4          | 5          | 30              | French               |\n" +
                "-----------------------------------------------------------------------------------------------------\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
