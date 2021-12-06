package com.switchfully.order.repositories;

import com.switchfully.order.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultUserRepository implements UserRepository {

    private final ConcurrentHashMap<String, User> usersById;

    public DefaultUserRepository() {
        usersById = new ConcurrentHashMap<>();

    }

    @Override
    public User saveUser(User user) {
        usersById.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> getUser(String username) {
        return usersById.values()
                .stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
