package com.switchfully.order.domain;


import java.time.LocalDate;

public class ItemGroup {
    private final String itemId;
    private final int amount;
    private final LocalDate shippingDate;
    private final int price;

    public ItemGroup(String itemId, int amount, LocalDate shippingDate, int price) {
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


}
