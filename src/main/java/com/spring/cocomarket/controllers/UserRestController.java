package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.User;
import com.spring.cocomarket.interfaces.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserRestController {
    @Autowired
    IUserService userService;
    @GetMapping("/retrieve-all-users")
    public List<User> retriveAllUsers(){
        List<User> listUsers = userService.retrieveAllUsers();
        return listUsers;
    }
    @GetMapping("/retrieve-user/{id}")
    public User retrieveUser(@PathVariable("id") Integer id){
        return userService.retrieveUser(id);
    }
    @PostMapping("/add-user")
    public User addUser (@RequestBody User u){
        User user = userService.addUser(u);
        return user;
    }
    @DeleteMapping("/remove-user/{id}")
    public void removeUser(@PathVariable("id") Integer id){
        userService.removeUser(id);
    }
    @PutMapping("/update-user")
    public User updateUser(@RequestBody User u) {
        User user= userService.updateUser(u);
        return user;
    }
}
