package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import com.in28minutes.rest.webservices.restfulwebservices.beans.Post;
import com.in28minutes.rest.webservices.restfulwebservices.beans.UserBean;
import com.in28minutes.rest.webservices.restfulwebservices.dao.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.dao.UserRepository;
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
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<UserBean> retrieveAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Resource<UserBean> retreieveUser(@PathVariable int id) {
        Optional<UserBean> userBean = userRepository.findById(id);
        if(!userBean.isPresent()) {
            throw new UserNotFoundException("id " + id);
        }
        Resource<UserBean> resource = new Resource<UserBean>(userBean.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody UserBean userBean) {
        UserBean userSaved = userRepository.save(userBean);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("{id}").
                buildAndExpand(userSaved.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePost(@PathVariable int id) {
        Optional<UserBean> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity createPost(@PathVariable int id, @RequestBody Post post) {

        Optional<UserBean> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        UserBean user = userOptional.get();
        post.setUserBean(user);

        postRepository.save(post);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
