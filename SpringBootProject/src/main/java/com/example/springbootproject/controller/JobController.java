package com.example.springbootproject.controller;

import com.example.springbootproject.entity.Job;
import com.example.springbootproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/saveJob")
    public String saveJob(@ModelAttribute("job") Job job, Model model){
        jobService.saveJob(job);
        model.addAttribute("jobs", jobService.getAllJobs());
        return "job";
    }



}
