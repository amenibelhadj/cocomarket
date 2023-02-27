package com.spring.cocomarket.controllers;

import com.spring.cocomarket.authentication.AuthenticationRequest;
import com.spring.cocomarket.entities.User;
import com.spring.cocomarket.interfaces.IUserService;
import com.spring.cocomarket.repositories.UserRepository;
import com.spring.cocomarket.utils.PagingHeaders;
import com.spring.cocomarket.utils.PagingResponse;
import com.sun.scenario.effect.ImageData;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Status;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
@SecurityRequirement(name = "javainuseapi")
@Validated
public class UserRestController {
    @Autowired
    IUserService userService;
    @Autowired
    private UserRepository userRepository;

    ///////////////// CRUD/////////////////////////

    @GetMapping("/show-all-users")
    public List<User> retriveAllUsers() {
        List<User> listUsers = userService.retrieveAllUsers();
        return listUsers;
    }

    @GetMapping("/show-user/{id}")
    public User retrieveUser(@Valid @PathVariable("id") Integer id) {
        return userService.retrieveUser(id);
    }

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@Valid @RequestBody User u) {
        User user = userService.addUser(u);
        return ResponseEntity.ok("User added successfully!");
    }

    @DeleteMapping("/remove-user/{id}")
    public ResponseEntity<String> removeUser(@PathVariable("id") Integer id) {
        userService.removeUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }

    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@Valid @RequestBody User u) {
        User user = userService.updateUser(u);
        return ResponseEntity.ok("User updated successfully!");
    }


    ///////////////////TRI FILTRE PAGINATION////////////
    @Transactional
    @GetMapping(value = "/recherche-avancee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> get(
            @And({
                    @Spec(path = "firstname", params = "firstname", spec = Like.class),
                    @Spec(path = "lastname", params = "lastname", spec = Like.class),
                    @Spec(path = "email", params = "email", spec = Like.class),
                    @Spec(path = "company", params = "company", spec = Like.class),
                    @Spec(path = "address", params = "address", spec = Like.class),
                    @Spec(path = "fidelity", params = "fidelity", spec = Like.class),
                    @Spec(path = "role", params = "role", spec = Like.class)
            }) Specification<User> spec, Sort sort, @RequestHeader HttpHeaders headers) {
        final PagingResponse response = userService.get3(spec, headers, sort);
        return new ResponseEntity<>(response.getElements(), returnHttpHeaders(response), HttpStatus.OK);

    }

    public HttpHeaders returnHttpHeaders(PagingResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
        headers.set(PagingHeaders.PAGE_OFFSET.getName(), String.valueOf(response.getPageOffset()));
        headers.set(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(response.getPageNumber()));
        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
        return headers;
    }

    /////////////Image Upload/////////////
    @ApiOperation(value = "Upload a logo file")
    @PostMapping(value = "/uploadLogo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadLogo(@RequestParam("file") MultipartFile file, AuthenticationRequest authentication) {
        User user = userRepository.findByEmail(authentication.getEmail()).get();

        try {
            user.setLogo(file.getBytes());
            userRepository.save(user);
            return ResponseEntity.ok("Logo uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload logo");
        }
    }

}
