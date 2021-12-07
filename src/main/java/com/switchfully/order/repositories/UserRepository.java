package com.switchfully.order.repositories;

import com.switchfully.order.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User saveUser(User user);

    User getUserByUsername(String username);
    User getUserBy(String email);

    List<User> getAllCustomers();
}
