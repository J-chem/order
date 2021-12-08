package com.switchfully.order.domain.orders.dto;

import com.switchfully.order.domain.valueobjects.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.switchfully.order.domain.valueobjects.Currency.EUR;
import static org.assertj.core.api.Assertions.assertThat;

class OverviewDTOTest {

    private OverviewDTO overviewDTO;

    @BeforeEach
    void setUp() {
        Set<OverviewItemGroupDTO> overviewItemGroupDTOS = new HashSet<>();
        overviewItemGroupDTOS.add(
                new OverviewItemGroupDTO()
                        .setItemName("test1")
                        .setAmount(5)
                        .setPrice(new Price(5, EUR)
                        ));
        overviewItemGroupDTOS.add(
                new OverviewItemGroupDTO()
                        .setItemName("test2")
                        .setAmount(10)
                        .setPrice(new Price(1, EUR)
                        ));
        List<OverviewOrderDTO> overviewOrders = List.of(
                new OverviewOrderDTO("test_id_1", overviewItemGroupDTOS),
                new OverviewOrderDTO("test_id_2", overviewItemGroupDTOS)
        );
        overviewDTO = new OverviewDTO(overviewOrders);
    }

    @Test
    void whenGetTotalPrice_thenReturn70() {
        assertThat(overviewDTO.calculateTotalPrice(overviewDTO.getOverviewOrders())).isEqualTo(70);
    }
}