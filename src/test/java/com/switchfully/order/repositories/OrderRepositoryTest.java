package com.switchfully.order.repositories;

import com.switchfully.order.domain.Item;
import com.switchfully.order.domain.ItemGroup;
import com.switchfully.order.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class OrderRepositoryTest {

    private DefaultOrderRepository defaultOrderRepository;
    private Item item;
    private Order order;
    private ItemGroup itemGroup;

    @BeforeEach
    void setUp() {
        item = new Item("name", "description", 10, 100);
        order = new Order();
        itemGroup = new ItemGroup(item.getId(), 5, LocalDate.now().plusDays(1));
        order.addItem(itemGroup);
        defaultOrderRepository = new DefaultOrderRepository();
    }

    @Test
    void whenSavingOrder_thenReturnOrder() {
        assertThat(defaultOrderRepository.save(order)).isEqualTo(order);
    }

}