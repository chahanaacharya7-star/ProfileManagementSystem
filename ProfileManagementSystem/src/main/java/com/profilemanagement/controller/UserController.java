package com.profilemanagement.controller;

import com.profilemanagement.dao.UserDao;
import com.profilemanagement.model.User;

import java.util.List;

public class UserController {
    private final UserDao dao = new UserDao();

    public boolean addUser(String name, String email, String password) {
        User user = new User(name, email, password);
        return dao.insertUser(user);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public User getUserById(int id) {
        return dao.getUserById(id);
    }
}
