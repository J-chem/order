package com.switchfully.order.domain.orders;


import com.switchfully.order.domain.valueobjects.Price;

import java.time.LocalDate;

public class ItemGroup {
    private final String itemId;
    private final int amount;
    private final LocalDate shippingDate;
    private final Price price;

    public ItemGroup(String itemId, int amount, LocalDate shippingDate, Price price) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Price getPrice() {
        return price;
    }
}
