package org.example.processor;

import org.example.product.Product;

public class OrderProcessor<T extends Product> implements OrderHandler<T> {
    public T product;

    public OrderProcessor(T product) {
        this.product = product;
    }

    @Override
    public void processOrder(T product) {
        try {
            if (product == null) {
                throw new NullPointerException("Product cannot be null");
            }
            System.out.println("Processing order for: " + product.getName());
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void startProcessing() {
        Runnable task = () -> System.out.println("Processing product in thread: " + Thread.currentThread().getName());
        new Thread(task).start();
    }
}
