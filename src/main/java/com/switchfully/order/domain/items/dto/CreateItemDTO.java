package com.switchfully.order.domain.items.dto;

import com.switchfully.order.domain.valueobjects.Price;

import static com.switchfully.order.domain.valueobjects.Currency.EUR;

public class CreateItemDTO {
    private final String name;
    private final String description;
    private final Price price;
    private final int amount;

    public CreateItemDTO(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = new Price(price, EUR);
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
