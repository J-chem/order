package com.switchfully.order.domain.valueobjects;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0 && currency == price1.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, currency);
    }
}
