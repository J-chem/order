package com.switchfully.order.repositories;

import com.switchfully.order.domain.Address;
import com.switchfully.order.domain.TelephoneNumber;
import com.switchfully.order.domain.User;
import com.switchfully.order.exceptions.UnknownUserException;
import com.switchfully.order.security.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserRepositoryTest {

    private User user1;
    private Address address1;
    private TelephoneNumber telephoneNumber1;
    private User admin;
    private Address address2;
    private TelephoneNumber telephoneNumber2;
    private DefaultUserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new DefaultUserRepository();
        telephoneNumber1 = new TelephoneNumber("05", "5234567");
        address1 = new Address("streetName", "streetNumber", "postalCode", "city");
        user1 = new User("firstName", "lastName", "email@email.email", address1, telephoneNumber1, Role.CUSTOMER, "username", "password");
        telephoneNumber2 = new TelephoneNumber("03", "1234567");
        address2 = new Address("streetName", "streetNumber", "postalCode", "city");
        admin = new User("firstName", "lastName", "email@email.email", address1, telephoneNumber1, Role.ADMIN, "username", "password");
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
        @DisplayName("Wrong username")
        void whenWrongUserName_thenUnknownUserException() {
            assertThatThrownBy(() -> userRepository.getUserByUsername("test"))
                    .isInstanceOf(UnknownUserException.class)
                    .hasMessage("Unknown user");
        }
        @Test
        @DisplayName("Get a user")
        void whenGettingAUser_thenReturnUser() {
            userRepository.saveUser(user1);
            assertThat(userRepository.getUserByUsername(user1.getUsername())).isEqualTo(user1);
        }
    }

    @Nested
    @DisplayName("all customers")
    class GetAllCustomers {
        @Test
        @DisplayName("get all customers")
        void whenGetAllCustomers_thenReturnUser1AndNOTAdmin() {
            userRepository.saveUser(user1);
            userRepository.saveUser(admin);
            assertThat(userRepository.getAllCustomers()).containsExactly(user1);
        }
    }
}