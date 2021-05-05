package com.example.springbootproject.controller;

import com.example.springbootproject.entity.User;
import com.example.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    /*
    //Hämtar info "get" och renderar en vy
    @GetMapping("/showFormUser")
    public String showFormUser(@ModelAttribute("user") User user, Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "user";
    }

    //Skicka information "post" sparar en användare
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/showFormUser";
    }*/


    /*****************************SAVE USER*********************************/
    //Getmapping ska hantera views
    @GetMapping("/")
    public String welcome(@ModelAttribute("user") User user){
        return "user";
    }

    @GetMapping("/success")
    public String success(@ModelAttribute("user") User user,
                          Model model){
        model.addAttribute("msg", "Du har sparats");
        return "user";
    }

    @GetMapping("/failed")
    public String failed(@ModelAttribute("user") User user,
                         Model model){
        model.addAttribute("msg", "Oj nåt gick fel!");
        return "user";
    }

    /*
    //Att en metod endast ska göra en sak
    //Skicka information "post" sparar en användare
    @PostMapping("/saveUserParam")
    public String saveUserParam(@RequestParam("name") String name,
                                @RequestParam("address") String address,
                                @RequestParam("passwordOne") String passwordOne,
                                @RequestParam("passwordTwo") String passwordTwo
                               ){

        if(passwordOne.equals(passwordTwo)){
            User user = new User();
            user.setName(name);
            user.setAddress(address);
            user.setPassword(passwordOne);
            userService.saveUser(user);
            return "redirect:/success";
        }

        return "redirect:/failed";

    }*/

    /******************************NYA METODEN****************************************/

    @PostMapping("/saveUser")
    public String saveUser(User user,
                            @RequestParam("password") String passwordOne,
                            @RequestParam("passwordTwo") String passwordTwo){

        if(passwordOne.equals(passwordTwo)){
            userService.saveUser(user);
            return "redirect:/success";
        }

        return "redirect:/failed";

    }

}
