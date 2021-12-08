package com.switchfully.order.domain.valueobjects;

public class Price {
    private final double price;
    private final Currency currency;

    public Price(double price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }
}
