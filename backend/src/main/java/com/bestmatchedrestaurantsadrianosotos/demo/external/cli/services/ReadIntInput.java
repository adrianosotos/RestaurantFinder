package com.bestmatchedrestaurantsadrianosotos.demo.external.cli.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ReadIntInput {
    private final Scanner scanner;

    @Autowired
    public ReadIntInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String prompt) {
        try {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return 0;
            } else {
                return Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
