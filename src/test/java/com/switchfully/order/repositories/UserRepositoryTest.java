package com.switchfully.order.repositories;

import com.switchfully.order.domain.Address;
import com.switchfully.order.domain.TelephoneNumber;
import com.switchfully.order.domain.User;
import com.switchfully.order.security.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest {

    private User user1;
    private Address address1;
    private TelephoneNumber telephoneNumber1;
    private DefaultUserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new DefaultUserRepository();
        telephoneNumber1 = new TelephoneNumber("03", "1234567");
        address1 = new Address("streetName", "streetNumber", "postalCode", "city");
        user1 = new User("firstName", "lastName", "email@email.email", address1, telephoneNumber1, Role.CUSTOMER);
    }

    @Nested
    @DisplayName("Saving a user")
    class SaveAUser {
        @Test
        @DisplayName("Save a user")
        void whenSavingAUser_thenReturnUser() {
            assertThat(userRepository.saveUser(user1)).isEqualTo(user1);
        }
    }

    @Nested
    @DisplayName("Get a user")
    class GetAUser {
        @Test
        @DisplayName("Get a user")
        void whenGettingAUser_thenReturnUser() {
            assertThat(userRepository.getUser("userName")).isEmpty();
            userRepository.saveUser(user1);
            assertThat(userRepository.getUser(user1.getUsername())).hasValue(user1);
        }
    }
}