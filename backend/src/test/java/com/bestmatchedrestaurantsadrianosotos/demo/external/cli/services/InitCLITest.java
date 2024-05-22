package com.bestmatchedrestaurantsadrianosotos.demo.external.cli.services;

import com.bestmatchedrestaurantsadrianosotos.demo.TestUtils.TestUtils;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.external.cli.services.*;
import com.bestmatchedrestaurantsadrianosotos.demo.external.services.GetRestaurants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InitCLITest {
    private InitCLI initCLI;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    Scanner scanner;

    @Mock
    ReadStringInput readStringInput;

    @Mock
    ReadIntInput readIntInput;

    @Mock
    PrintRestaurantTable printRestaurantTable;

    @Mock
    GetRestaurants getRestaurants;

    @BeforeEach
    public void setUp() {
        initCLI = new InitCLI(scanner,readIntInput, readStringInput, printRestaurantTable, getRestaurants);
    }

    @Test
    public void testRunToPrintTable() throws Exception {
        List<Restaurant> testRestaurants = new ArrayList<>();
        testRestaurants.add(TestUtils.createRestaurant("test", 1, 1, 1, "Italian"));

        when(getRestaurants.find(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any(), Mockito.any())).thenReturn(testRestaurants);
        when(scanner.nextLine()).thenReturn("Y").thenReturn("N");

        initCLI.init();

        Mockito.verify(printRestaurantTable, atLeastOnce()).printTable(anyList());
        Mockito.verify(scanner).close();
    }

    @Test
    public void testRunToShowMessageWithNoMatches() throws Exception {
        List<Restaurant> testRestaurants = new ArrayList<>();

        when(getRestaurants.find(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any(), Mockito.any())).thenReturn(testRestaurants);
        when(scanner.nextLine()).thenReturn("Y").thenReturn("N");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        initCLI.init();

        System.setOut(System.err);

        String output = out.toString();
        assertTrue(output.contains("No matches to criteria"));

    }
}
