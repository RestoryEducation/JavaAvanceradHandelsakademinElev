package com.example.secondlession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FrontController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

}
