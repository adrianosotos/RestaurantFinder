package com.bestmatchedrestaurantsadrianosotos.demo.external.cli.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadStringInputTest {

    private ReadStringInput readStringInput;

    @BeforeEach
    public void setUp() {
        String input = "Test input\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        readStringInput = new ReadStringInput(scanner);
    }

    @Test
    public void testReadLine() {
        String prompt = "Enter a string: ";

        String result = readStringInput.readLine(prompt);

        assertEquals("Test input", result);
    }
}
