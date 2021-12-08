package com.switchfully.order.repositories;

import com.switchfully.order.domain.users.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);

    User getUserByUsername(String username);
    User getUserBy(String email);

    List<User> getAllCustomers();
}
