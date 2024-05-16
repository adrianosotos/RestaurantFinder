package com.bestmatchedrestaurantsadrianosotos.demo.external;

import com.bestmatchedrestaurantsadrianosotos.demo.external.cli.RestaurantsCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	public RestaurantsCLI createRestaurantsCLI;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
