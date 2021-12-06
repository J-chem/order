package com.switchfully.order.services.dto;

import java.math.BigDecimal;

public class CreateItemDTO {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int amount;

    public CreateItemDTO(String name, String description, int price, int amount) {
        this.name = name;
        this.description = description;
        this.price = BigDecimal.valueOf(price);
        this.amount = amount;
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
        return amount;
    }
}
