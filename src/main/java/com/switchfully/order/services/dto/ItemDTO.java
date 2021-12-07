package com.switchfully.order.services.dto;

public class ItemDTO {
    private final String id;
    private final String name;
    private final String description;
    private final int price;
    private final int amount;

    private ItemDTO(String id, String name, String description, int price, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public static class ItemDTOBuilder {
        private String id;
        private String name;
        private String description;
        private int price;
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

        public ItemDTOBuilder withPrice(int price) {
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
