package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.in28minutes.rest.webservices.restfulwebservices.beans.UserBean;
import com.in28minutes.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/users")
    public List<UserBean> retrieveAllUser() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public Resource<UserBean> retreieveUser(@PathVariable int id) {
        UserBean userBean = userDaoService.findOne(id);
        if(userBean == null) {
            throw new UserNotFoundException("id " + id);
        }
        Resource<UserBean> resource = new Resource<UserBean>(userBean);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody UserBean userBean) {
        UserBean userSaved = userDaoService.save(userBean);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("{id}").
                buildAndExpand(userSaved.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public UserBean deleteUser(@PathVariable int id) {
        UserBean userBean = userDaoService.deleteById(id);
        if(userBean == null) {
            throw new UserNotFoundException("id " + id);
        }
        return userBean;
    }
}
