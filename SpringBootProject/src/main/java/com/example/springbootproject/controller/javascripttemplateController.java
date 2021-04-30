package com.example.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class javascripttemplateController {

    @GetMapping("/showPage")
    public String ShowPage() {
        return "javascripttemplate";
    }
}
