package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        this.users.findAll().forEach(users::add);
        return users;
    }

    public void add(User user) {
        users.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return users.findByUsername(username);
    }
}
