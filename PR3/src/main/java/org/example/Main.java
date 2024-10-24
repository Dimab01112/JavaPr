package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Calculator calc = new Calculator();

            try {
                System.out.print(" First number (a): ");
                double a = input.nextDouble();
                System.out.print("Second number (b): ");
                double b = input.nextDouble();

                System.out.print("Choose operation: ");
                char operator = input.next().charAt(0);

                double result;

                switch (operator) {
                    case '+':
                        result = calc.adding(a, b);
                        System.out.println("Result of adding: " + result);
                        break;
                    case '-':
                        result = calc.substruction(a, b);
                        System.out.println("Result of subtraction: " + result);
                        break;
                    case '*':
                        result = calc.multiply(a, b);
                        System.out.println("Result of multiplying: " + result);
                        break;
                    case '/':
                        result = calc.dividing(a, b);
                        System.out.println("Result of dividing: " + result);
                        break;
                    default:
                        System.out.println("Invalid operation selected.");
                }
            } catch (InvalidInputException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("An invalid symbol");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getClass());
            }finally {
                System.out.println("Processing complete.");
            }
        }
    }

