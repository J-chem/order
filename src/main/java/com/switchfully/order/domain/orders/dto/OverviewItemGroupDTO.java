package com.switchfully.order.domain.orders.dto;

import com.switchfully.order.domain.valueobjects.Currency;
import com.switchfully.order.domain.valueobjects.Price;

import static com.switchfully.order.domain.valueobjects.Currency.EUR;

public class OverviewItemGroupDTO {

    private String itemName;
    private int amount;
    private Price price;

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }

    public Price getPrice() {
        return new Price((price.getPrice() * amount), EUR);
    }

    public OverviewItemGroupDTO setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public OverviewItemGroupDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public OverviewItemGroupDTO setPrice(Price price) {
        this.price = price;
        return this;
    }
}
