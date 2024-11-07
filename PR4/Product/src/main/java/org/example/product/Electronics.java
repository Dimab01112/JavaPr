package org.example.product;

import lombok.Builder;

public class Electronics extends Product {
    @Builder
    public Electronics(String name, Double price, String description) {
        super(name, price, description);
    }
}
