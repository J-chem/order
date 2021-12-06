package com.switchfully.order.repositories;

import com.switchfully.order.domain.User;

import java.util.Optional;

public interface UserRepository {
    User saveUser(User user);
    Optional<User> getUser(String username);
}
