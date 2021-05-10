package com.example.springbootproject.controller;

import com.example.springbootproject.entity.User;
import com.example.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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


    /******************************v.19 Måndag****************************************/
    //Endpoint to handle view which shows a table with
    //all user entries in the database.
    @GetMapping("/admin")
    public ModelAndView adminDashbord(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin");
        List<User> users = userService.getAllUsers();
        mv.addObject("users", users);
        return mv;
    }

    //Endpoint for editing specific database entries
    //Their id field is used to query them from the database.
    @GetMapping("/edit/{id}")
    public ModelAndView updateUser(@PathVariable long id ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit");
        User userToUpdate = userService.findUserById(id);
        mv.addObject(userToUpdate);
        return mv;
   }

   //Endpoint that handles updating a specific user
   @PostMapping("/update-user")
   public String updateUser(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:/admin";
   }
    //Endpoint that handles deleting a specific user
   @GetMapping("/delete/{id}")
   public String deleteUser(@PathVariable long id ){
        userService.deleteUser(id);
        return "redirect:/admin";
   }


    //Entpoint for authenticating user from database
    //testing is done with Postman
/*    @PostMapping("/user/auth")
    @ResponseBody
    public boolean authUser(@RequestBody User user){
        return userService.authUser(user);
    }*/

    //Endpoint which returns the login view
    @GetMapping("/login")
    public String loginView(@ModelAttribute("user") User user){
       return "login";
    }

    //Handles user authentication, returns either an error or success message
    @PostMapping("/authenticate-user")
    public String authUser(@RequestParam String name, @RequestParam String password){
        if(userService.authUser(name, password)){
            return "redirect:/authenticated";
        }
        return "redirect:/authError";
    }

    //Success response from above method which displays
    //a message dynamically in the login form
    @GetMapping("/authenticated")
    public String authenticated(Model model){
        model.addAttribute("msg", "You Are Logged In");
        return "login";
    }
    //Fail response from above method which displays
    //a message dynamically in the login form
    @GetMapping("/authError")
    public String authError(Model model){
        model.addAttribute("msg", "Login Failed");
        return "login";
    }

    /******************************v.19 Måndag****************************************/

}
