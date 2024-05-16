package com.bestmatchedrestaurantsadrianosotos.demo.external.config;

import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.FindRestaurants;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.MatchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.ports.Repository;
import com.bestmatchedrestaurantsadrianosotos.demo.infra.adapters.db.CsvRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class FindRestaurantsConfig {
    @Bean
    public FindRestaurants FindRestaurants() throws IOException {
        String filePathRestaurants = "src/main/java/com/bestmatchedrestaurantsadrianosotos/demo/infra/db/restaurants.csv";
        String filePathCuisene = "src/main/java/com/bestmatchedrestaurantsadrianosotos/demo/infra/db/cuisines.csv";

        Repository repository = new CsvRepository(createBufferReader(filePathRestaurants), createBufferReader(filePathCuisene), new MatchCriteria());
        return new FindRestaurants(repository);
    }

    private BufferedReader createBufferReader(String path) throws FileNotFoundException {
        return new BufferedReader(new FileReader(path));
    }
}
