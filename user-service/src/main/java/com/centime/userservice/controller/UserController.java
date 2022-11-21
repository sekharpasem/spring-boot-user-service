package com.centime.userservice.controller;

import com.centime.userservice.entity.User;
import com.centime.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /***
     * save user
     * @param user
     * @return
     */
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    /**
     * get user
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") Long id){
        log.info("Inside getUser of UserController");
        return userService.getUser(id);
    }

    /***
     * gets parent users
     * @param id
     * @return
     */
    @GetMapping("/parent/{id}")
    public Optional<User> getPrentUsers(@PathVariable("id") Long id){
        log.info("Inside getPrentUsers of UserController");
        return userService.getUser(id);
    }

    /***
     * gets all
     * @return
     */
    @GetMapping("/list")
    public List<User> getAll(){
        log.info("Inside getAll of UserController");
        return userService.getAll();
    }
}
