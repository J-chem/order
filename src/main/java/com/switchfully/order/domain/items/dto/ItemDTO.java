package com.switchfully.order.domain.items.dto;

import com.switchfully.order.domain.valueobjects.Price;

public class ItemDTO {
    private final String id;
    private final String name;
    private final String description;
    private final Price price;
    private final int stock;

    private ItemDTO(String id, String name, String description, Price price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
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

    public Price getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public static class ItemDTOBuilder {
        private String id;
        private String name;
        private String description;
        private Price price;
        private int amount;

        public ItemDTOBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public ItemDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ItemDTOBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemDTOBuilder withPrice(Price price) {
            this.price = price;
            return this;
        }

        public ItemDTOBuilder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public ItemDTO build() {
            return new ItemDTO(id, name, description, price, amount);
        }
    }
}
