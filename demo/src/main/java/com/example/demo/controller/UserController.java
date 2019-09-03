package com.example.demo.controller;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;    
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody User newUser){
    	return userRepository.save(newUser);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") String id){
        User user = userRepository.findBy_id(id);
        return user;
    }
}
