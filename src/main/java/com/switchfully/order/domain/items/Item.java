package com.switchfully.order.domain.items;

import com.switchfully.order.domain.valueobjects.Price;

import java.util.Objects;
import java.util.UUID;

public class Item {
    // INSTANCE VARIABLES
    private final String id;
    private String name;
    private String description;
    private Price price;
    private int stock;

    // CONSTRUCTORS
    public Item(String name, String description, Price price, int stock) {
        this.id = UUID.randomUUID().toString();
        setName(name);
        setDescription(description);
        setPrice(price);
        setStock(stock);
    }

    // GETTERS
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

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // METHODS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
