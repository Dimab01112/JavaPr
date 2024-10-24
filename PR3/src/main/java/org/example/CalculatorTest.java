package org.example;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();


    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.dividing(10, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testInvalidInputNaN() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            calculator.adding(Double.NaN, 5);
        });
        assertEquals("Inputs values are not valid numbers.", exception.getMessage());
    }

    @Test
    public void testInputMismatchException() {
        Scanner scanner = new Scanner("invalid_symbol");
        assertThrows(InputMismatchException.class, () -> {
            double a = scanner.nextDouble();
        });
    }
}
