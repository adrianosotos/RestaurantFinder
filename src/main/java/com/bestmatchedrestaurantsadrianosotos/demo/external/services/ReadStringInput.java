package com.bestmatchedrestaurantsadrianosotos.demo.external.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ReadStringInput {
    private final Scanner scanner;

    @Autowired
    public ReadStringInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input.trim();
    }
}
