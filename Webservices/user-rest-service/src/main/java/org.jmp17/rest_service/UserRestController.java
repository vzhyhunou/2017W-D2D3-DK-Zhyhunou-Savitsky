package org.jmp17.rest_service;

import io.swagger.annotations.Api;
import org.jmp17.rest_service.data.UserRepository;
import org.jmp17.rest_service.exception.UserNotFoundException;
import org.jmp17.rest_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * Created by asavitsky on 3/17/17.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User user){
        createUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable long id) throws UserNotFoundException {
        User user = userRepository.findOne(id);
        if( user==null )
            throw new UserNotFoundException();
        return user;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        userRepository.delete(id);
    }

}
