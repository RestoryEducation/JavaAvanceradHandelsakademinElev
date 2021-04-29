package com.example.javajpademo.Controller;

import com.example.javajpademo.Entity.User;
import com.example.javajpademo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class FrontController {

    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String welcome(@ModelAttribute("user") User user,
                          Model model) {

        model.addAttribute("users", userService.GetAllUsers());

        return "index";
    }

    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/welcome";
    }

    @GetMapping("/pagetwo")
    public String startpagetwo() {
        return "pagetwo";
    }

}
