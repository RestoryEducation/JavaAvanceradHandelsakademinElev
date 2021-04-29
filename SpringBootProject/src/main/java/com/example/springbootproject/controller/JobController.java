package com.example.springbootproject.controller;

import com.example.springbootproject.entity.Job;
import com.example.springbootproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/showFormJob")
    public String showFormJob(@ModelAttribute("job") Job job, Model model){
        model.addAttribute("jobs", jobService.getAllJobs());
        return "job";
    }

    @PostMapping("/saveJob")
    public String saveJob(@ModelAttribute("job") Job job){
        jobService.saveJob(job);
        return "redirect:/showFormJob";
    }

}
