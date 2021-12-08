package com.switchfully.order.repositories;

import com.switchfully.order.domain.users.Address;
import com.switchfully.order.domain.users.TelephoneNumber;
import com.switchfully.order.domain.users.User;
import com.switchfully.order.exceptions.UnknownUserException;
import com.switchfully.order.security.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultUserRepository implements UserRepository {

    private final ConcurrentHashMap<String, User> usersById;

    public DefaultUserRepository() {
        usersById = new ConcurrentHashMap<>();
        addAdmin();
    }

    private void addAdmin() {
        User admin = new User("hardCodeAdmin", "hardCodeAdmin", "email@email.email",
                new Address("streetName", "streetNumber", "postalCode", "city"),
                new TelephoneNumber("03", "1234567"),
                Role.ADMIN,
                "hardCodeAdmin",
                "hardCodeAdmin");
        usersById.put(admin.getId(), admin);
    }

    @Override
    public User saveUser(User user) {
        usersById.put(user.getId(), user);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return usersById.values()
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UnknownUserException("Unknown user"));
    }

    @Override
    public User getUserBy(String email) {
        return usersById.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No user matched the data"));
    }

    @Override
    public List<User> getAllCustomers() {
        return usersById.values()
                .stream()
                .filter(user -> user.getRole().equals(Role.CUSTOMER))
                .toList();
    }
}
