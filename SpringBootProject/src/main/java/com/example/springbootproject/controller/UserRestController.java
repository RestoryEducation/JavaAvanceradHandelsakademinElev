package com.example.springbootproject.controller;

import com.example.springbootproject.entity.User;
import com.example.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // @Controller + @ResponseBody
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsersRest() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public void createUserRest(@RequestBody User user) {
        userService.saveUser(user);
    }

}
