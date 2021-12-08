package com.switchfully.order.domain.orders.dto;

import com.switchfully.order.domain.valueobjects.Price;

import java.util.Set;

import static com.switchfully.order.domain.valueobjects.Currency.EUR;

public class OverviewOrderDTO {

    private final String orderId;
    private final Price totalPriceOrder;
    private final Set<OverviewItemGroupDTO> overviewItemGroupDTOS;

    public OverviewOrderDTO(String orderId, Set<OverviewItemGroupDTO> overviewItemGroupDTOS) {
        this.orderId = orderId;
        this.totalPriceOrder = new Price(calculateTotalPriceOrder(overviewItemGroupDTOS), EUR);
        this.overviewItemGroupDTOS = overviewItemGroupDTOS;
    }

    private double calculateTotalPriceOrder(Set<OverviewItemGroupDTO> overviewItemGroupDTOS) {
        return overviewItemGroupDTOS.stream()
                .map(overview -> overview.getPrice().getPrice())
                .reduce(0.0, Double::sum);
    }

    public String getOrderId() {
        return orderId;
    }

    public Price getTotalPriceOrder() {
        return totalPriceOrder;
    }

    public Set<OverviewItemGroupDTO> getOverviewItemGroupDTOS() {
        return overviewItemGroupDTOS;
    }
}
