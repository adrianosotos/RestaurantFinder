package com.bestmatchedrestaurantsadrianosotos.demo.external.cli;

import com.bestmatchedrestaurantsadrianosotos.demo.external.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class RestaurantsCLITest {
    private RestaurantsCLI restaurantCLI;

    @Mock
    InitCLI initCLI;

    @BeforeEach
    public void setUp() {
        restaurantCLI = new RestaurantsCLI(initCLI);
    }

    @Test
    public void testRunCLI() throws Exception {
        restaurantCLI.run();
        Mockito.verify(initCLI).init();
    }
}


