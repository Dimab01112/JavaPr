package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders; // Список збережених замовлень

    // Конструктор
    public OrderHistory() {
        this.orders = new ArrayList<>();
    }


    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Метод для виведення історії замовлень
    @Override
    public String toString() {
        if (orders.isEmpty()) {
            return "Історія замовлень порожня.";
        }

        StringBuilder sb = new StringBuilder("Історія замовлень:\n");
        for (Order order : orders) {
            sb.append(order.toString()).append("\n------------------\n");
        }
        return sb.toString();
    }
}
