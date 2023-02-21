package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.User;
import com.spring.cocomarket.interfaces.IUserService;
import com.spring.cocomarket.utils.PagingHeaders;
import com.spring.cocomarket.utils.PagingResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Status;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
@SecurityRequirement(name = "javainuseapi")
@Validated
public class UserRestController {
    @Autowired
    IUserService userService;

    ///////////////// CRUD/////////////////////////
    @GetMapping("/show-all-users")
    public List<User> retriveAllUsers(){
        List<User> listUsers = userService.retrieveAllUsers();
        return listUsers;
    }
    @GetMapping("/show-user/{id}")
    public User retrieveUser(@Valid @PathVariable("id") Integer id){
        return userService.retrieveUser(id);
    }

    @PostMapping("/add-user")
    public User addUser (@Valid @RequestBody User u){
        User user = userService.addUser(u);
        return user;
    }
    @DeleteMapping("/remove-user/{id}")
    public void removeUser(@PathVariable("id") Integer id){
        userService.removeUser(id);
    }

    @PutMapping("/update-user")
    public User updateUser(@Valid @RequestBody User u) {
        User user= userService.updateUser(u);
        return user;
    }



    ///////////////////TRI FILTRE PAGINATION////////////
    @Transactional
    @GetMapping(value = "/springdata",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> get (
            @And({
                    @Spec(path = "firstname",params = "firstname",spec = Like.class),
                    @Spec(path = "lastname",params = "lastname",spec = Like.class),
                    @Spec(path = "email",params = "email",spec = Like.class),
                    @Spec(path = "company",params = "company",spec = Like.class),
                    @Spec(path = "address",params = "address",spec = Like.class),
                    @Spec(path = "fidelity",params = "fidelity",spec = Like.class),
                    @Spec(path = "role",params = "role",spec = Like.class)
            })Specification<User> spec, Sort sort,@RequestHeader HttpHeaders headers)
    {
        final PagingResponse response=userService.get3(spec,headers,sort);
        return new ResponseEntity<>(response.getElements(),returnHttpHeaders(response),HttpStatus.OK);

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


}
