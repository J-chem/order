package com.switchfully.order.repositories;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.domain.orders.ItemGroup;
import com.switchfully.order.domain.orders.Order;
import com.switchfully.order.domain.users.Address;
import com.switchfully.order.domain.users.TelephoneNumber;
import com.switchfully.order.domain.users.User;
import com.switchfully.order.domain.valueobjects.Price;
import com.switchfully.order.security.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static com.switchfully.order.domain.valueobjects.Currency.EUR;
import static org.assertj.core.api.Assertions.assertThat;

class OrderRepositoryTest {

    private DefaultOrderRepository defaultOrderRepository;
    private DefaultItemRepository defaultItemRepository;
    private Item item;
    private Order order;
    private User customer;
    private TelephoneNumber telephoneNumber;
    private Address address;
    private ItemGroup itemGroup;

    @BeforeEach
    void setUp() {
        telephoneNumber = new TelephoneNumber("03", "1234567");
        address = new Address(
                "streetName",
                "streetNumber",
                "postalCode",
                "city");
        customer = new User(
                "firstName",
                "lastName",
                "email@email.email",
                address,
                telephoneNumber,
                Role.CUSTOMER,
                "username",
                "password");
        Price price = new Price(10, EUR);
        item = new Item("name", "description", price, 100);
        itemGroup = new ItemGroup(item.getId(), 5, LocalDate.now().plusDays(1), item.getPrice());
        order = new Order(customer.getId(), Set.of(itemGroup));
        defaultOrderRepository = new DefaultOrderRepository();
        defaultItemRepository = new DefaultItemRepository();
        defaultItemRepository.saveItem(item);
    }

    @Test
    void whenSavingOrder_thenReturnOrder() {
        assertThat(defaultOrderRepository.placeOrder(order)).isEqualTo(order);
    }

}