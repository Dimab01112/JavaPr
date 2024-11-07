package org.example.main;

import com.github.javafaker.Faker;
import org.example.processor.OrderProcessor;
import org.example.product.Clothing;
import org.example.product.Electronics;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var faker = new Faker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Product Ordering System!");
        System.out.println("Please choose an option:");
        System.out.println("1. Order Clothing");
        System.out.println("2. Order Electronics");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> orderClothing(faker);
            case 2 -> orderElectronics(faker);
            default -> System.out.println("Invalid option. Please restart the program and choose a valid option.");
        }

        scanner.close();
    }

    private static void orderClothing(Faker faker) {
        var clothing = Clothing.builder()
                .name(faker.beer().name())
                .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                .description(faker.beer().name())
                .build();

        OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(clothing);
        clothingOrder.processOrder(clothing);
        clothingOrder.startProcessing();

        List<Clothing> clothingList = IntStream.range(0, 10)
                .mapToObj(i -> Clothing.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                        .description(faker.lebowski().quote())
                        .build())
                .toList();

        System.out.println("Processing clothing orders:");
        clothingList.parallelStream()
                .map(OrderProcessor::new)
                .forEach(order -> {
                    order.processOrder(((OrderProcessor<Clothing>) order).product);
                    order.startProcessing();
                });
    }

    private static void orderElectronics(Faker faker) {
        var electronics = Electronics.builder()
                .name(faker.company().name())
                .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                .description(faker.commerce().material())
                .build();

        OrderProcessor<Electronics> electronicsOrder = new OrderProcessor<>(electronics);
        electronicsOrder.processOrder(electronics);
        electronicsOrder.startProcessing();

        System.out.println("Electronics order processed:");
        System.out.printf("Name: %s, Price: %.2f, Description: %s%n",
                electronics.getName(), electronics.getPrice(), electronics.getDescription());
    }
}
