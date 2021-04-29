package com.example.springbootproject.service;

import com.example.springbootproject.entity.Job;
import com.example.springbootproject.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    //Spara jobb med hjälp av inbyggd metod som kommer från mitt extendade interface Jparepository
    public void saveJob(Job job){
        jobRepository.save(job);
    }

    //Visa alla job med hjälp av inbyggd metod från jpaprepository
    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

}
