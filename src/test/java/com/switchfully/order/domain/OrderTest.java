package com.switchfully.order.domain;

import com.switchfully.order.repositories.DefaultItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;
    private Item item1;
    private Item item2;
    private DefaultItemRepository defaultItemRepository;

    @BeforeEach
    void setUp() {
        defaultItemRepository = new DefaultItemRepository();
        order = new Order();
        item1 = new Item("name", "description", BigDecimal.TEN, 100);
        item2 = new Item("name", "description", BigDecimal.TEN, 0);
    }

    @Test
    void aNewOrderIsEmpty() {
        assertThat(order.getItemGroups()).isEmpty();
    }

    @Test
    void whenAddingAnItemGroup_thenOrderContainsItemGroup() {
        ItemGroup itemGroup = new ItemGroup(item1.getId(), 5, LocalDate.now().plusDays(1));
        order.addItem(itemGroup);
        assertThat(order.getItemGroups()).containsOnly(itemGroup);
    }

    @Test
    void whenAddingAnItemTwice_itsOnlyOnceInTheOrder() {
        ItemGroup itemGroup = new ItemGroup(item1.getId(), 5, LocalDate.now().plusDays(1));
        order.addItem(itemGroup);
        order.addItem(itemGroup);
        assertThat(order.getItemGroups()).containsOnly(itemGroup);
    }

    @Test
    void whenAddingTwoDifferentItems_theyApperaBothInTheOrder() {
        ItemGroup itemGroup1 = new ItemGroup(item1.getId(), 5, LocalDate.now().plusDays(1));
        ItemGroup itemGroup2 = new ItemGroup(item2.getId(), 10, LocalDate.now().plusDays(1));
        order.addItem(itemGroup1);
        order.addItem(itemGroup2);
        assertThat(order.getItemGroups()).containsOnly(itemGroup1, itemGroup2);
    }
}