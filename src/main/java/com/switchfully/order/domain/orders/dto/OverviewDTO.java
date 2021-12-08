package com.switchfully.order.domain.orders.dto;

import com.switchfully.order.domain.valueobjects.Price;
import java.util.List;

import static com.switchfully.order.domain.valueobjects.Currency.EUR;

public class OverviewDTO {

    private final List<OverviewOrderDTO> overviewOrders;
    private final Price totalPrice;

    // CONSTRUCTORS
    public OverviewDTO(List<OverviewOrderDTO> overviewOrders) {
        this.totalPrice = new Price(calculateTotalPrice(overviewOrders), EUR);
        this.overviewOrders = overviewOrders;
    }

    // GETTERS
    public Price getTotalPrice() {
        return totalPrice;
    }

    public List<OverviewOrderDTO> getOverviewOrders() {
        return overviewOrders;
    }

    // METHODS
    public double calculateTotalPrice(List<OverviewOrderDTO> overviewOrders) {
        return overviewOrders.stream()
                .map(order -> order.getTotalPriceOrder().getPrice())
                .reduce(0.0, Double::sum);
    }
}
