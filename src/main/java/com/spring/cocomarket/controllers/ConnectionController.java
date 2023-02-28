package com.spring.cocomarket.controllers;
import com.spring.cocomarket.entities.User;
import com.spring.cocomarket.interfaces.UserService;
import com.spring.cocomarket.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;


/*


    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody User user) {

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(@RequestBody User user) {
        User disconnectedUser = userService.disconnect(user);
        template.convertAndSend("/channel/logout", disconnectedUser);
    }

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> findConnectedUsers() {
        return userRepo.findAll();
    }

    @RequestMapping(value = "/clearAll", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearAll() {
        userRepo.deleteAll();
    }
*/
}
