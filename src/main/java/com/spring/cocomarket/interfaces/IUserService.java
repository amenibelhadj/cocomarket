package com.spring.cocomarket.interfaces;

import com.spring.cocomarket.entities.User;

import java.util.List;

public interface IUserService {
    List<User> retrieveAllUsers();
    User retrieveUser (Integer id);
    User updateUser (User user);
    User addUser (User user);
    void removeUser (Integer id);
}
