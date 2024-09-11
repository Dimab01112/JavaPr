package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics));
        products.add(new Product(2, "Смартфон", 12999.5, "Смартфон з великим екраном та високою автономністю", smartphones));
        products.add(new Product(3, "Навушники", 2499.0, "Бездротові навушники з шумозаглушенням", accessories));

        Cart cart = new Cart();
        OrderHistory orderHistory = new OrderHistory(); // Створення об'єкта для збереження історії замовлень

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Переглянути історію замовлень");
            System.out.println("7 - Пошук товарів за назвою або категорією");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чистим буфер
            switch (choice) {
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                case 1:
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int addId = scanner.nextInt();
                    Product productToAdd = findProductById(products, addId);
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd);
                        System.out.println("Товар додано до кошика.");
                    } else {
                        System.out.println("Товар з таким ID не знайдено");
                    }
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    if (cart.removeProductById(removeId)) {
                        System.out.println("Товар видалено з кошика.");
                    } else {
                        System.out.println("Товар з таким ID не знайдено у кошику.");
                    }
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        orderHistory.addOrder(order); // Додавання замовлення в ысторыю
                        cart.clear();
                    }
                    break;
                case 6:
                    System.out.println(orderHistory); // показиваем історії замовлень
                    break;
                case 7:
                    System.out.println("Введіть назву товару або категорії для пошуку:");
                    String searchQuery = scanner.nextLine();
                    List<Product> searchResults = searchProducts(products, searchQuery);
                    if (searchResults.isEmpty()) {
                        System.out.println("Товари за вашим запитом не знайдено.");
                    } else {
                        System.out.println("Знайдені товари:");
                        for (Product product : searchResults) {
                            System.out.println(product);
                        }
                    }
                    break;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
            }
        }
    }


    // Метод для пошуку товару за ID
    private static Product findProductById(List<Product> products, int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    private static List<Product> searchProducts(List<Product> products, String query) {
        List<Product> results = new ArrayList<>();
        String searchQuery = query.toLowerCase().trim(); // Приведення запиту до нижнього регістру та видалення зайвих пробілів
        for (Product product : products) {
            // Перевірка, чи відповідає назва товару або категорії запиту
            String productName = product.getName().toLowerCase().trim();
            String categoryName = product.getCategory().getName().toLowerCase().trim();
            if (productName.contains(searchQuery) || categoryName.contains(searchQuery)) {
                results.add(product);
            }
        }
        return results;
    }

}
