package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.User;
import com.spring.cocomarket.interfaces.IUserService;
import com.spring.cocomarket.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository ur;

    @Override
    public List<User> retrieveAllUsers() {
        return ur.findAll();
    }

    @Override
    public User retrieveUser(Integer id) {
        return ur.findById(id).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return ur.save(user);
    }

    @Override
    public User addUser(User user) {
        return ur.save(user);
    }

    @Override
    public void removeUser(Integer id) {
        ur.deleteById(id);
    }
}
