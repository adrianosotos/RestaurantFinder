package com.bestmatchedrestaurantsadrianosotos.demo.external.cli;

import com.bestmatchedrestaurantsadrianosotos.demo.external.cli.services.InitCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RestaurantsCLI implements CommandLineRunner {
    private final InitCLI initCLI;

    @Autowired
    public RestaurantsCLI(InitCLI initCLI)  {
        this.initCLI = initCLI;
    }

    @Override
    public void run(String ...args) throws Exception {
        this.initCLI.init();
    }
}
