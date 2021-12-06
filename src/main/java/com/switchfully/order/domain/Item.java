package com.switchfully.order.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {
    private String id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int Amount;

    public Item(String name, String description, BigDecimal price, int amount) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        Amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmount() {
        return Amount;
    }
}
