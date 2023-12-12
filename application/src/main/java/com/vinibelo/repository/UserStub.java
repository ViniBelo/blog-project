package com.vinibelo.repository;

import domain.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserStub {
    private final Map<UUID, User> users = new HashMap<>();

    public void saveUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUserById(UUID userId) {
        return users.get(userId);
    }
}
