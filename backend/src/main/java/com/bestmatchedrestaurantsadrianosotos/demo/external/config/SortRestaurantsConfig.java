package com.bestmatchedrestaurantsadrianosotos.demo.external.config;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.SortRestaurants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SortRestaurantsConfig {
    @Bean
    public SortRestaurants SortRestaurantsConfig() {
        return new SortRestaurants();
    }
}

