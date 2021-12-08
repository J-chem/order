package com.switchfully.order.domain.items.dto;

import com.switchfully.order.domain.valueobjects.Price;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CreateItemDTO {
    @NotNull
    @NotBlank(message = "Name is mandatory")
    private final String name;
    @NotNull
    @NotBlank(message = "Description is mandatory")
    private final String description;
    @NotBlank(message = "Price is mandatory")
    private final Price price;
    private final int stock;

    public CreateItemDTO(String name, String description, Price price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = Objects.requireNonNull(stock);
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

    public int getStock() {
        return stock;
    }
}
