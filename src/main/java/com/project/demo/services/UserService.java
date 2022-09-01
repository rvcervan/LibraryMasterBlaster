package com.project.demo.services;

import com.project.demo.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<User> getAll();

    User getUser(int id);

    User createUser(User u);

    User updateUser(User u, int id);

    void deleteUser(int id);

    void deleteAll();
}
