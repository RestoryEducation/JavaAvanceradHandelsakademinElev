package com.example.springbootproject.service;

import com.example.springbootproject.entity.User;
import com.example.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow();
    }
}
