package com.bestmatchedrestaurantsadrianosotos.demo.external.cli.services;

import com.bestmatchedrestaurantsadrianosotos.demo.external.cli.services.ReadIntInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadIntInputTest {

    private ReadIntInput readIntInput;

    @BeforeEach
    public void setUp() {
        String input = "123\n"; // Simulated user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        readIntInput = new ReadIntInput(scanner);
    }

    @Test
    public void testReadInt_ValidInput() {
        String prompt = "Enter a number: ";
        int result = readIntInput.readInt(prompt);

        assertEquals(123, result);
    }

    @Test
    public void testReadInt_EmptyInput() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        ReadIntInput readIntInput = new ReadIntInput(scanner);
        String prompt = "Enter a number: ";

        int result = readIntInput.readInt(prompt);

        assertEquals(0, result);
    }

    @Test
    public void testReadInt_InvalidInput() {
        String input = "abc\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        ReadIntInput readIntInput = new ReadIntInput(scanner);
        String prompt = "Enter a number: ";

        int result = readIntInput.readInt(prompt);

        assertEquals(0, result);
    }
}
