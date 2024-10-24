package org.example;

public class Calculator {
    private void validate(double a, double b) throws InvalidInputException {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new InvalidInputException("Inputs values are not valid numbers.");
        }
        if (Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new InvalidInputException("Input values are infinite.");
        }
    }
    public double adding(double a, double b) throws InvalidInputException {
        validate(a, b);
        return a + b;
    }
    public double multiply(double a, double b) throws InvalidInputException {
        validate(a, b);
        return a * b;
    }
    public double dividing(double a, double b) throws InvalidInputException, ArithmeticException {
        validate(a, b);
        if (a==0 || b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public double substruction(double a, double b) throws InvalidInputException {
        validate(a, b);
        return a - b;
    }
}
