package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>(); // Список товарів у кошику

    // Метод для додавання товару до кошика
    public void addProduct(Product product) {
        products.add(product);
    }

    // Метод для видалення товару з кошика за ID
    public boolean removeProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                products.remove(product);
                return true; // Товар успішно видалено
            }
        }
        return false; // Товар з таким ID не знайдено
    }

    // Метод для отримання списку товарів
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    // Метод для отримання загальної вартості
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Метод для очищення кошика
    public void clear() {
        products.clear();
    }

    // Метод для виведення інформації про кошик
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кошик:\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        sb.append("Загальна вартість: ").append(getTotalPrice());
        return sb.toString();
    }
}
