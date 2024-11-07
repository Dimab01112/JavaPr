package org.example.processor;

import org.example.product.Product;

public interface OrderHandler<T extends Product> {
    void processOrder(T product);
}

