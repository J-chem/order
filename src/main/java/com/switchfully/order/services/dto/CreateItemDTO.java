package com.switchfully.order.services.dto;

import java.math.BigDecimal;

public class CreateItemDTO {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int Amount;

    public CreateItemDTO(String name, String description, BigDecimal price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        Amount = amount;
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
