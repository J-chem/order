package com.switchfully.order.domain;

import com.switchfully.order.repositories.DefaultItemRepository;
import com.switchfully.order.security.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    private Order order;
    private Item item1;
    private Item item2;
    private User customer;
    private TelephoneNumber telephoneNumber;
    private Address address;
    private DefaultItemRepository defaultItemRepository;

    @BeforeEach
    void setUp() {
        defaultItemRepository = new DefaultItemRepository();
        telephoneNumber = new TelephoneNumber("03", "1234567");
        address = new Address("streetName", "streetNumber", "postalCode", "city");
        customer = new User("firstName", "lastName", "email@email.email", address, telephoneNumber, Role.CUSTOMER, "username", "password");
        order = new Order();
        item1 = new Item("name", "description", 10, 100);
        item2 = new Item("name", "description", 10, 0);
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
    void whenAddingTwoDifferentItems_theyAppearBothInTheOrder() {
        ItemGroup itemGroup1 = new ItemGroup(item1.getId(), 5, LocalDate.now().plusDays(1));
        ItemGroup itemGroup2 = new ItemGroup(item2.getId(), 10, LocalDate.now().plusDays(1));
        order.addItem(itemGroup1);
        order.addItem(itemGroup2);
        assertThat(order.getItemGroups()).containsOnly(itemGroup1, itemGroup2);
    }
}