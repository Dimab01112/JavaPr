package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>(); // Список товарів у кошику

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                products.remove(product);
                return true; // Товар  видалено
            }
        }
        return false; // Товар  не знайдено
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

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
